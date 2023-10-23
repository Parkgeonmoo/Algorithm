import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static int[][] map,check;
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        check = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j  =1 ; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 원배열 입력

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                check[i][j] = check[i-1][j] + check[i][j-1]-check[i-1][j-1] +map[i][j];
            }
        }//누적합 계산

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
           int start_x = Integer.parseInt(st.nextToken());
           int start_y = Integer.parseInt(st.nextToken());
           int end_x = Integer.parseInt(st.nextToken());
           int end_y = Integer.parseInt(st.nextToken());
           int result = check[end_x][end_y] - check[start_x-1][end_y] -check[end_x][start_y-1] +check[start_x-1][start_y-1];
           System.out.println(result);

        }

    }
}