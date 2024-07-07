
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] sin;
    public static int[] ssen;
    public static int result = Integer.MAX_VALUE;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        sin = new int[N];
        ssen = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sin[i] = Integer.parseInt(st.nextToken());
            ssen[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);
        System.out.println(result);
    }

    public static void dfs(int index, int totalSin, int totalSsen, int selectedCount) {
        if (index == N) {
            if (selectedCount > 0) {
                result = Math.min(result, Math.abs(totalSin - totalSsen));
            }
            return;
        }
        dfs(index + 1, totalSin, totalSsen, selectedCount);
        dfs(index + 1, totalSin * sin[index], totalSsen + ssen[index], selectedCount + 1);
    }
}

