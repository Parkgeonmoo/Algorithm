import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] cheesemap;
    static boolean[][] visited;
    static int time = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int cheeseCount = 0;
    static int lastcheese = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheesemap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheesemap[i][j] = Integer.parseInt(st.nextToken());
                if (cheesemap[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }



        while (cheeseCount > 0) {
            visited = new boolean[N][M];
            lastcheese = cheeseCount;
            cheeseCount = cheesecheck(0, 0);
            time++;










        }

        System.out.println(time);
        System.out.println(lastcheese);
    }

    public static int cheesecheck(int startx, int starty) {
        ArrayList<int[]> cheeselist = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        visited[startx][starty] = true;
        q.offer(new int[]{startx, starty});

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (cheesemap[nx][ny] == 0) {
                            q.offer(new int[]{nx, ny});
                        } else if (cheesemap[nx][ny] == 1) {
                            cheeselist.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        // 치즈를 녹이고 치즈 개수를 감소시킴
        for (int[] temp : cheeselist) {
            int x = temp[0];
            int y = temp[1];
            cheesemap[x][y] = 0; // 치즈 녹임
            cheeseCount--;
        }

        return cheeseCount;
    }



}
