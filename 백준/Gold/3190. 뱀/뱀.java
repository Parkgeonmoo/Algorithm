import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;
    static Deque<Position> snake = new ArrayDeque<>();
    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위쪽
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            board[row][col] = 1; // 사과 위치 표시
        }
         //이해했음

        int L = Integer.parseInt(br.readLine());
        Direction[] directions = new Direction[L];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directions[i] = new Direction(time, dir);
        } // 이해했음

        int time = 0;
        int direction = 0;
        snake.add(new Position(0, 0));

        loop: while (true) {
            time++;
            int nx = snake.getFirst().x + dx[direction];
            int ny = snake.getFirst().y + dy[direction];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == -1) {
                break; // 벽이나 자기 자신과 부딪힘
            }

            if (board[nx][ny] == 0) {
                Position tail = snake.removeLast();
                board[tail.x][tail.y] = 0;
            }

            snake.addFirst(new Position(nx, ny));
            board[nx][ny] = -1; // 자기 자신을 나타내는 것

            for (Direction d : directions) {
                if (d.time == time) {
                    if (d.direction == 'D') {
                        direction = (direction + 1) % 4;
                    } else {
                        direction = (direction + 3) % 4;
                    }
                }
            }
        }

        System.out.println(time);
    }

    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Direction {
        int time;
        char direction;

        Direction(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }
}
