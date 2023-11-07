import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[][] dp = new long[55][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int result = (A*B) / gcd(A,B);
            System.out.println(result);
        }



    }
    public static int gcd(int A,int B) {
        if (B == 0) {
            return A;
        }
        else{
          return gcd(B,A % B);
        }
    }
}
