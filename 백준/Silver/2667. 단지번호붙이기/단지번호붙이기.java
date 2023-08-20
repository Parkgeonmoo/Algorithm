import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean [][] visited;
    static int[][] map;
    static int N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Integer> aparts = new ArrayList<>();
    static int blockcount = 0;
    static int apartsnum = 0;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) -'0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    apartsnum++;
                    bfs(i,j);
                }
            }
        }

        Collections.sort(aparts);
        System.out.println(apartsnum);

        for (int i = 0; i < aparts.size(); i++) {
            System.out.println(aparts.get(i));
        }


    }
    public static void bfs(int x,int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        visited[x][y] = true;
        blockcount = 1;
        while (!queue.isEmpty()) {
            int [] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] =true;
                        blockcount++;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
        aparts.add(blockcount);








    }
}
