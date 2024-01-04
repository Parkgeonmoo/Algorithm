
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Long, Long> dp = new HashMap<>();
    static long N, M, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        dp.put((long)0, (long)1);

        System.out.println(inf(N));
    }

    public static long inf(long N) {
        if(dp.containsKey(N)) {
            return dp.get(N);
        }

        dp.put(N, inf(N/M) + inf(N/Q));

        return dp.get(N);
    }
}


