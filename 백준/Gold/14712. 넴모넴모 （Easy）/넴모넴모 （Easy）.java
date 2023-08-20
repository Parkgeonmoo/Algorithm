import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static boolean[][] visited;
    static int N,M;
    static int answer = 0;
  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1][M+1];

        dfs(0);
        System.out.println(answer);


    }
    public static void dfs(int count) {
        if (count == N*M) {
            answer++;
            return;
        }

        int x = count/M + 1;
        int y = count%M + 1;

        if (visited[x-1][y-1] == true && visited[x-1][y] ==  true && visited[x][y-1] == true) {
            dfs(count+1);
        }
        else{
            dfs(count+1);
            visited[x][y] = true;
            dfs(count+1);
            visited[x][y] = false;
        }


     }
}