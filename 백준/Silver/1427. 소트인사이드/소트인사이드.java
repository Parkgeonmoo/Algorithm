
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
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String type = String.valueOf(N);
        int[] ans = new int[type.length()];

        for (int i = 0; i < type.length(); i++) {
            ans[i] = Integer.parseInt(type.substring(i,i+1));
        }

        Arrays.sort(ans);

        for (int i = ans.length - 1; i >= 0; i--) {
            sb.append(ans[i]);
        }

        System.out.println(Integer.parseInt(sb.toString()));

    }
}