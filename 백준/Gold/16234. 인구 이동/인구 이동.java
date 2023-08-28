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
    static boolean canmove;

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


        while(true) {
            visited = new boolean[N][N];
            canmove = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            canmove = true;
                        }
                    }
                }
            }

            if (!canmove) {
                break;
            }
            countday++;
        }

        System.out.println(countday);


    }
    public static boolean bfs(int startx,int starty) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> unionlist = new ArrayList<>();
        visited[startx][starty] = true;
        q.offer(new int[] {startx,starty});
        int unioncount = map[startx][starty];
        unionlist.add(new int[]{startx,starty});




        while (!q.isEmpty()){
            int [] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N ) {
                    int diff = Math.abs(map[temp[0]][temp[1]] - map[nx][ny]);
                    if (diff >= L && diff <= R && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                        unionlist.add(new int[]{nx,ny});
                        unioncount += map[nx][ny];

                    }
                }
            }
        }
        if (unionlist.size() > 1) {
            int avg = unioncount / unionlist.size();

            for (int [] temp : unionlist) {
                map[temp[0]][temp[1]] = avg;
            }
            return true;
        }

        return false;
    }
}
