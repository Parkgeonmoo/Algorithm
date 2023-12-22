import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] D = new int[N + 1][10];
        int[] S = new int[N + 1];

        for (int i = 0; i <= 9; i++) {
            D[1][i] = 1;
            S[1] += D[1][i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    D[i][j] = (D[i][j] + D[i - 1][k]) % 10007;
                }
                S[i] = (S[i] + D[i][j]) % 10007;
            }
        }

        System.out.println(S[N] % 10007);
    }
}
