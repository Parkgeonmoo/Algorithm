import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int [][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean [][] visited;
    static int startx,starty;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startx = i;
                    starty = j;
                }
            }
        }

        bfs(startx,starty);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1){
                    sb.append(-1 + " ");
                }
                else{
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }
    public static void bfs(int startx,int starty) {
        Queue<int[]> queue = new LinkedList();
        visited[startx][starty] = true;
        map[startx][starty] = 0;
        queue.offer(new int[] {startx,starty});

         while(!queue.isEmpty()) {
             int[] temp = queue.poll();

             for (int i = 0; i < 4; i++) {
                 int nx = temp[0] + dx[i];
                 int ny = temp[1] + dy[i];

                 if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                     if (!visited[nx][ny] && map[nx][ny] != 0) {
                         visited[nx][ny] = true;
                         map[nx][ny] = map[temp[0]][temp[1]] + 1;
                         queue.add(new int[] { nx,ny});
                     }
                 }
             }
         }




    }
}