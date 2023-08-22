import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, n;
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 2; i <= n; i++) {
               if (i % 2 == 1) {
                   for (int j = 0; j < r; j++) {
                       for (int k = 0; k < c; k++) {
                           if (map[j][k] == 'O') {
                               q.add(new int[] {j,k});
                           }
                       }
                   }
                   for (char [] m : map) {
                       Arrays.fill(m, 'O');
                   }
                   bfs();
               }

        }

        if (n % 2 == 0) {
            for (char[] c : map) {
                Arrays.fill(c,'O');
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
    public static void bfs(){
        while(!q.isEmpty()) {
            int [] temp = q.poll();
            map[temp[0]][temp[1]] = '.';

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (map[nx][ny] == 'O') {
                        map[nx][ny] = '.';
                    }
                }
            }
        }
    }

}