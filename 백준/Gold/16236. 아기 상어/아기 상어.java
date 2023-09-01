import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position implements Comparable<Position> {
    int x, y, dist;

    public Position(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Position o) {
        if (this.dist != o.dist) {
            return Integer.compare(this.dist, o.dist);
        }
        if (this.x != o.x) {
            return Integer.compare(this.x, o.x);
        }
        return Integer.compare(this.y, o.y);
    }
}

class Shark {
    int x, y;

    public Shark(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int size = 2;
    static int count = 0;
    static int second = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        Shark shark = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int moveTime = findFishAndMove(shark);
            if (moveTime == -1) {
                break;
            }
            second += moveTime;
        }

        System.out.println(second);
    }

    public static int findFishAndMove(Shark shark) {
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        ArrayList<Position> eatableFish = new ArrayList<>();

        q.offer(new Position(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;
        

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                Position current = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = current.x + dx[d];
                    int ny = current.y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        if (map[nx][ny] <= size) {
                            q.offer(new Position(nx, ny, current.dist + 1));
                            visited[nx][ny] = true;

                            if (map[nx][ny] > 0 && map[nx][ny] < size) {
                                eatableFish.add(new Position(nx, ny, current.dist + 1));
                                
                            }
                        }
                    }
                }
            }

            if (!eatableFish.isEmpty()) {
                Collections.sort(eatableFish);
                Position fishToEat = eatableFish.get(0);
                map[fishToEat.x][fishToEat.y] = 0;
                shark.x = fishToEat.x;
                shark.y = fishToEat.y;
                count++;

                if (count == size) {
                    size++;
                    count = 0;
                }

                return fishToEat.dist;
            }
        }

        return -1;
    }
}
