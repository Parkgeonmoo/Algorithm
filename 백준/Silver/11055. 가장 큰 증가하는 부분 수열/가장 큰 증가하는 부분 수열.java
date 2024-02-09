
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+1];
        int[] O = new int[N+1];
        int answer = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            O[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            D[i] = O[i];
            for (int j = 1; j < i; j++) {
                if (O[j] < O[i] && D[i] < D[j] + O[i]) {
                    D[i] = D[j] + O[i];
                }
            }
            answer = Math.max(answer, D[i]);
        }

        System.out.println(answer);
    }
}

