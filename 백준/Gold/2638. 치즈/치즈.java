import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N,M;
    static boolean[][] visited;
    static boolean is_cheese= false;
    static int time = 0;
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            is_cheese = false;
            visited = new boolean[N][M];
            aircheck(0,0);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && cheesecheck(i,j)) {
                        map[i][j] = 0;
                        is_cheese = true;
                    }
                }
            }

            if (!is_cheese){
                break;
            }

            time++;

        }

        System.out.println(time);




    }
    public static void aircheck(int startx,int starty) {
        Queue<int[]> q = new LinkedList<>();
        visited[startx][starty] = true;
        q.offer(new int[]{startx,starty});

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx,ny});
                    }
                }
            }
        }


    }

    public static boolean cheesecheck(int startx,int starty){
        int airCount = 0;

        for (int i = 0; i < 4; i++) {
            int nx = startx + dx[i];
            int ny = starty + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] && map[nx][ny] == 0) {
                airCount++;
            }
        }

        return airCount >= 2;
    }
}