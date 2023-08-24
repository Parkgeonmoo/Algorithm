import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int countday = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            boolean canMove = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            canMove = true;
                        }
                    }
                }
            }

            if (!canMove) {
                break;
            }

            countday++;
        }

        System.out.println(countday);
    }

    public static boolean bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        visited[startX][startY] = true;
        q.offer(new int[]{startX, startY});
        int populationSum = map[startX][startY];
        union.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[temp[0]][temp[1]] - map[nx][ny]);

                    if (diff >= L && diff <= R) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        populationSum += map[nx][ny];
                    }
                }
            }
        }

        if (union.size() > 1) {
            int average = populationSum / union.size();

            for (int[] coord : union) {
                map[coord[0]][coord[1]] = average;
            }

            return true;
        }

        return false;
    }
}
