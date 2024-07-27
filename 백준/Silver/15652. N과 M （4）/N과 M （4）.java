import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int N;
    static int M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        find(arr, 0, M);
        System.out.println(sb.toString());
    }

    public static void find(int[] arr, int depth, int M) {
        if (depth == M) {
            for (int temp : arr) {
                sb.append(temp + " ");
            }
            sb.append("\n");
            return;
        }

        int start = (depth == 0) ? 1 : arr[depth - 1];

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            find(arr, depth + 1, M);
        }
    }
}
