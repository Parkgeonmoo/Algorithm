
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer,Integer> answer = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] O = new int[N];
        int [] C = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            O[i] = Integer.parseInt(st.nextToken());
            C[i] = O[i];
        }

        Arrays.sort(C);
        int idx = 0;

        for (int i = 0; i < C.length; i++) {
            if (answer.containsKey(C[i])) {
                continue;
            }
            else {
                answer.put(C[i],idx);
                idx++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (answer.containsKey(O[i])) {
                sb.append(answer.get(O[i]) + " ");
            }
        }

        System.out.println(sb.toString());









    }
}

