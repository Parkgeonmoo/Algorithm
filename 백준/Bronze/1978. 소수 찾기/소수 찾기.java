
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] prime = new int[1001];
        boolean[] check = new boolean[1001];
        int count = 0;

        for (int i = 2; i <= 1000; i++) {
            prime[i] = i;
        }

        check[0] = true;
        check[1] = true;

        for (int i = 2; i <= Math.sqrt(1000); i++) {
            if (check[i] == true) continue;
            for (int j = i + i; j <= 1000; j = j + i) {
                check[j] = true;
            }
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!check[num]) {
                count++;
            }
        }

        System.out.println(count);



    }
}
