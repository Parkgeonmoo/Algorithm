
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int nowX = 0;
    public static int nowY = 0;

    public static int answer = 0;
    public static boolean[][] visited;
    public static char[][] map;

    public static int N ;
    public static int M ;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                if (line[j] == 'I') {
                    nowX = i;
                    nowY = j;
                }
                map[i][j] = line[j];
            }
        }

        DFS(nowX,nowY);

        if (answer != 0) {
            System.out.println(answer);
        }
        else {
            System.out.println("TT");
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < N && newY >= 0 && newY < M && !visited[newX][newY] && map[newX][newY] != 'X') {
                if (map[newX][newY] == 'P') {
                    answer++;
                }
                visited[newX][newY] = true;
                DFS(newX, newY);
            }
        }
    }
}


