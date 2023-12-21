import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, W;
    static int[] fall;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        fall = new int[T + 1];
        dp = new int[T + 1][W + 2];

        for (int i = 1; i <= T; i++) {
            fall[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (fall[i] == 1) {
                    if (j % 2 == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                } else {
                    if (j % 2 == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= W + 1; i++) {
            max = Math.max(max, dp[T][i]);
        }

        System.out.println(max);
    }
}
