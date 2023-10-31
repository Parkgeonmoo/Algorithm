import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Arrays;

import static java.util.Collections.reverseOrder;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] ans = new int[N];
        int[] sum = new int[N];

        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ans);

        sum[0] = ans[0];
        int total = sum[0];

        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + ans[i];
            total += sum[i];
        }

        System.out.println(total);








    }
}