
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N];
        int Result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            int K = map[i];

            while (start < end) {
                if (map[start] + map[end] == K) {
                    if (start != i && end != i) {
                        Result++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                }
                else if (map[start] + map[end] < K) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        System.out.println(Result);

    }
}

