
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] D;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        D = new int[202][202];

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0) {
                    D[i][j] = 1;
                }
                else {
                    D[i][j] = D[i-1][j] + D[i-1][j-1];
                    if (D[i][j] > 1000000000) {
                        D[i][j] = 1000000000;
                    }
                }
            }
        }

        if (D[N+M][M] < K) {
            System.out.println(-1);
        }
        else {
            while (!(N == 0 && M == 0)) {

                if (D[N - 1 + M][M] >= K) {
                    sb.append("a");
                    N--;
                } else {
                    sb.append("z");
                    K = K - D[N - 1 + M][M];
                    M--;
                }
            }
        }
        System.out.println(sb.toString());








    }
}
