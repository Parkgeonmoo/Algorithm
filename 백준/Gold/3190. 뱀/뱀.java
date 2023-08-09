import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int K;
    static Deque<snake> snakes = new ArrayDeque<>();
    static position[] positions;
    static int[][] map;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int Ax = Integer.parseInt(st.nextToken()) - 1;
            int Ay = Integer.parseInt(st.nextToken()) - 1;
            map[Ax][Ay] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        positions = new position[L];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            positions[i] = new position(X, C);
        }

        int direction = 0;
        snakes.add(new snake(0, 0));

        for (position temp : positions) {
            while (time < temp.time) {
                time++;

                int nx = snakes.getFirst().x + dx[direction];
                int ny = snakes.getFirst().y + dy[direction];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == -1) {
                    System.out.println(time);
                    return;
                }

                if (map[nx][ny] == 0) {
                    snake tail = snakes.pollLast();
                    map[tail.x][tail.y] = 0;
                }

                snakes.addFirst(new snake(nx, ny));
                map[nx][ny] = -1;
            }

            if (temp.position == 'D') {
                direction = (direction + 1) % 4;
            } else {
                direction = (direction + 3) % 4;
            }
        }

        // Handle remaining time
        while (true) {
            time++;

            int nx = snakes.getFirst().x + dx[direction];
            int ny = snakes.getFirst().y + dy[direction];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == -1) {
                System.out.println(time);
                return;
            }

            if (map[nx][ny] == 0) {
                snake tail = snakes.pollLast();
                map[tail.x][tail.y] = 0;
            }

            snakes.addFirst(new snake(nx, ny));
            map[nx][ny] = -1;
        }
    }

    public static class position {
        int time;
        char position;

        position(int time, char position) {
            this.time = time;
            this.position = position;
        }
    }

    public static class snake {
        int x;
        int y;

        snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
