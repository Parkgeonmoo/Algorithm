import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }
    static final int MAX = 751;
    static int R, C;
    static int[][] map, D1, D2, D3, D4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        init();

        for(int r = 0 ; r < R ; ++r){
            char[] tmp = br.readLine().toCharArray();
            for(int c = 0 ; c < C ; ++c){
                map[r][c] = (int)tmp[c]-'0';
            }
        }
        if(R == 1 && C == 1) {
            System.out.println(map[0][0]);
            return;
        }

        for(int i = 0 ; i < R + C - 2 ; ++i){ // r+c == i 인 경우
            for (int c = 0; c < C; ++c) {
                int r = i - c;
                if (!isInRange(r, c)) continue;
                if (!isInRange(r + 1, c - 1)) D1[r][c] = map[r][c];
                else D1[r][c] = map[r][c] * (D1[r + 1][c - 1] + 1);
            }
            for (int r = 0; r < R; ++r) {
                int c = i - r;
                if (!isInRange(r, c)) continue;
                if (!isInRange(r - 1, c + 1)) D2[r][c] = map[r][c];
                else D2[r][c] = map[r][c] * (D2[r - 1][c + 1] + 1);
            }
        }
        for (int i = 1-C; i <= R-1; ++i) { // r-c = i인 애들을 살펴볼 예정
            for (int r = 0; r < R; ++r) {
                int c = r - i;
                if (!isInRange(r, c)) continue;
                if (!isInRange(r - 1, c - 1)) D3[r][c] = map[r][c];
                else D3[r][c] = map[r][c] * (D3[r - 1][c - 1] + 1);
            }
            for (int r = R-1; r >= 0 ; r--) {
                int c = r - i;
                if (!isInRange(r, c)) continue;
                if (!isInRange(r + 1, c + 1)) D4[r][c] = map[r][c];
                else D4[r][c] = map[r][c] * (D4[r + 1][c + 1] + 1);
            }
        }

        int max = 0;
        for(int r = 0; r < R ; ++r){
            for(int c = 0 ; c < C; ++c){
                int commonMaxSize = Math.min(D2[r][c], D4[r][c]);
                if(commonMaxSize < max) continue;

                for(int i = commonMaxSize ; i >= 1; i--){
                    int nextC = c+2*(i-1);

                    if (nextC >= C) continue;
                    if (i < max) break;
                    if(Math.min(D1[r][nextC], D3[r][nextC]) >= i){
                        max = Math.max(max, i);
                        break;
                    }
                }
            }
        }
        System.out.println(max);
    }
    private static void init(){
        map = new int[MAX][MAX];
        D1 = new int[MAX][MAX]; // 남서 방향으로 몇개 가 이어지는가? D[i][j] = (i, j)에서 시작한 1이 연속된 개수
        D2 = new int[MAX][MAX]; // 북동
        D3 = new int[MAX][MAX]; // 북서
        D4 = new int[MAX][MAX]; // 남동
    }
    private static boolean isInRange(int r, int c){
        if( r < 0 || r >= R || c < 0 || c >= C ) return false;
        return true;
    }
}