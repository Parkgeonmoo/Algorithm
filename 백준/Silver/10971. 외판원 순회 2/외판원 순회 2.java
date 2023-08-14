import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static int[][] map;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i =0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

            visited = new boolean[N];
            visited[0] = true;
            find(0,0,0);


        System.out.println(Min);


    }
    public static void find(int start,int now,int cost) {
        if (allvisited()) {
            if (map[now][start] != 0) {
                Min = Math.min(Min,cost+map[now][start]);
            }
            return;
        }
        for (int i = 1; i < N; i++) {
            if (!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                find(start,i,cost+map[now][i]);
                visited[i] = false;
            }
        }

    }

    public static boolean allvisited() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }


}