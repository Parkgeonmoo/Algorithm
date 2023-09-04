import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int max = 0;

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                    visited = new boolean[N][M];
                }
            }
        }

        System.out.println(max);



}
public static void bfs(int startx,int starty){
        Queue<treasure> q = new LinkedList<>();
        visited[startx][starty] = true;
        q.offer(new treasure(startx,starty,0));

        while (!q.isEmpty()) {
            treasure temp = q.poll();

            for (int  i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 'L') {
                        visited[nx][ny] = true;
                        q.offer(new treasure(nx,ny,temp.count+1));
                        max = Math.max(max,temp.count+1);
                    }
                }
            }
        }
}



}
class treasure{
    int x;
    int y;
    int count;

    public treasure(int x,int y,int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}