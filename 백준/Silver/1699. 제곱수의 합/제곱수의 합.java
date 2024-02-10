
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+1];


        D[0] = 0;
        D[1] = 1;

        for (int i = 2; i <= N; i++) {
            D[i] = D[i-1] + 1;

            for (int j = 1; j * j <= i; j++) {
                D[i] = Math.min(D[i],D[i-j*j] + 1);
            }
        }

        System.out.println(D[N]);






    }
}

