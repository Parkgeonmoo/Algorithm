import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static char[][] classroom;
    static int ans;
    static boolean[] visited;
    static int[] checked = new int[7];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        classroom = new char[5][5];
        for (int i = 0; i < 5; i++) {
            classroom[i] = br.readLine().toCharArray();
        }

        comb(0, 0, 0);
        System.out.println(ans);
    }


    static void comb(int cnt, int start, int dasomCnt) {
        if (cnt - dasomCnt > 3) return;

        if (cnt == 7) {
            visited = new boolean[7];
            bfs(checked[0]/5, checked[0]%5);
            return;
        }

        for (int i = start; i < 25; i++) {
            int row = i/5;
            int col = i%5;
            checked[cnt] = i;
            comb(cnt+1, i+1, (classroom[row][col] == 'S')? dasomCnt+1: dasomCnt);
        }

    }


    static void bfs(int i, int j) {
        int num = 1;
        visited[0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] rowCol = queue.poll();
            int r = rowCol[0];
            int c = rowCol[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = r + dx[dir];
                int ny = c + dy[dir];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5){
                int nxt = (5 * nx) + ny;
                for (int k = 0; k < 7; k++) {
                    if (!visited[k] && checked[k] == nxt) {
                        visited[k] = true;
                        num++;
                        queue.offer(new int[]{nx, ny});
                    }
                }
                }
            }
        }
        if (num == 7) ans++;
    }
}