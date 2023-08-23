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

    static int countday = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();











    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    q.add(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty()) {
            int [] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (map[nx][ny] != 0) {
                        continue;
                    }
                    map[nx][ny] = map[temp[0]][temp[1]] + 1;
                    q.add(new int[] {nx,ny});

                    }
                }
            }

        countday = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                countday = Math.max(countday,map[i][j]);
            }

        }
        System.out.println(countday-1);
        }





    }

