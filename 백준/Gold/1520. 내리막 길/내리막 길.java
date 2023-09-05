import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main{
    static int M,N;
    static int[][] map;
    static int[][] dp;

    static boolean[][] visit;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};



    public static void main(String[]args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];
        dp = new int[M][N];

        for (int i = 0 ; i < M; i++) {
            String [] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);

            }
        }
        dp[M-1][N-1] = 1;
        dfs(0,0);

        System.out.println(dp[0][0]);
    }
    public static void dfs(int x, int y) {
        if(x==M-1 && y==N-1) {
            return;
        }
        if(visit[x][y]){
            return;
        }
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >=0 && cy >= 0 && cx < M && cy < N && map[x][y] > map[cx][cy]  ) {
                if(dp[cx][cy] !=0 ) {
                    dp[x][y] += dp[cx][cy];
                    continue;
                } else{
                    dfs(cx,cy);
                    dp[x][y] += dp[cx][cy];
                }
            }
        }
    }

}
