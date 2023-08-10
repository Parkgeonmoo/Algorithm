import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int N;
    static int M;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        find(0);

        System.out.println(sb.toString());
    }

    public static void find(int depth) {
        if (depth == M) {
            for (int temp : result) {
                sb.append(temp).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;  // 이전에 선택한 원소 초기화

        for (int i = 0; i < N; i++) {
            if (!visited[i] &&  prev != arr[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                prev = arr[i];
                find(depth + 1);
                visited[i] = false;
            }
        }
    }
}
