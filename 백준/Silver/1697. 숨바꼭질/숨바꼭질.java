
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] check = new int[100001];
        Arrays.fill(check, -1);
        Queue<Integer> queue = new LinkedList<>();

        check[N] = 0;
        queue.add(N);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == K) {
                System.out.println(check[current]);
                break;
            }
            int[] next = {current - 1, current + 1, 2 * current};
            for (int i = 0; i < 3; i++) {
                if (next[i] >= 0 && next[i] <= 100000 && check[next[i]] == -1) {
                    queue.add(next[i]);
                    check[next[i]] = check[current] + 1;
                }
            }
        }
    }
}

