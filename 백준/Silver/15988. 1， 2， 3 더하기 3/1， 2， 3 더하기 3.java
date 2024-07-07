import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int T;
    public static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        dp = new long[1000001]; // 문제의 최대 n 값에 맞게 설정
        dp[0] = 1; // dp[0]은 1로 설정
        dp[1] = 1; // 1을 만드는 방법 1가지
        dp[2] = 2; // 2를 만드는 방법 2가지 (1+1, 2)
        dp[3] = 4; // 3을 만드는 방법 4가지 (1+1+1, 1+2, 2+1, 3)

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009; 
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
