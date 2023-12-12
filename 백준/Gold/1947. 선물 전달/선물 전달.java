
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] D = new long[1000001];
        long mod = 1000000000;

        D[0] = 0;
        D[1] = 0;
        D[2] = 1;

        //내가 선물을 양뱡향으로 교환하거나 또는 선물을 단방향으로 교환하는 방법

        for (int i = 3; i <= N; i++) {
            D[i] = ((D[i-1] + D[i-2]) * (i-1)) % mod;
        }

        System.out.println(D[N]);




    }
}
