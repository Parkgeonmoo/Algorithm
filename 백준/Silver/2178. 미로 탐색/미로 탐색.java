import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(map[N-1][M-1]);







    }

    public static void bfs(int startx,int starty) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startx,starty});
        visited[startx][starty] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {

                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[temp[0]][temp[1]] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}

