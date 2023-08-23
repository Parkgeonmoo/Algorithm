import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static ArrayList<Integer> arraylist = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] == true &&  map[i][j] == 1) {
                    bfs(i,j);
                }
            }
        }
        Collections.sort(arraylist);
        System.out.println(arraylist.size());

        for (int temp : arraylist) {
            System.out.println(temp);
        }









    }

    public static void bfs(int startx,int starty) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startx,starty});
        visited[startx][starty] = true;
        int checkapartnum = 1;
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        checkapartnum++;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        arraylist.add(checkapartnum);

    }
}

