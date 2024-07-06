
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        dfs(0, "");

        System.out.println(sb.toString());
    }

    public static void dfs(int depth, String permutation) {
        if (depth == N) {
            sb.append(permutation).append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, permutation + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}
