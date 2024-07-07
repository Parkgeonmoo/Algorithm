
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int K;
    public static int[] arr;
    public static Set<String> set;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, "");
        System.out.println(set.size());
    }

    public static void dfs(int depth, String current) {
        if (depth == K) {
            set.add(current);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, current + arr[i]);
                visited[i] = false;
            }
        }
    }
}
