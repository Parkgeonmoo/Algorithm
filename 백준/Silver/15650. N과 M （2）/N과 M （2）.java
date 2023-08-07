import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = new int[M];
        visited = new boolean[N + 1];
        find(N, M, 0);

        System.out.println(sb.toString());
    }

    public static void find(int N, int M, int depth) {
        if (depth == M) {
            for (int temp : result) {
                sb.append(temp).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (depth == 0 || result[depth - 1] < i)) {
                visited[i] = true;
                result[depth] = i;
                find(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
