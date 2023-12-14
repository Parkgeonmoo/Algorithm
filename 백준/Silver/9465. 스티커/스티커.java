
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int k = 1; k <= N; k++)
                    sticker[j][k] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int L = 2; L <= N; L++) {
                dp[0][L] = Math.max(dp[1][L-1],dp[1][L-2]) + sticker[0][L];
                dp[1][L] = Math.max(dp[0][L-1],dp[0][L-2]) + sticker[1][L];
            }

            int max = Math.max(dp[0][N], dp[1][N]);
            sb.append(max).append("\n");


        }


        System.out.print(sb);
    }
}