import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static ArrayList<Integer> arr;
    public static int max = Integer.MIN_VALUE;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        dfs(arr, arr.size(), 0);
        System.out.println(max);
    }

    public static void dfs(ArrayList<Integer> arr, int size, int currentResult) {
        if (size == 2) {
            max = Math.max(currentResult, max);
            return;
        }

        for (int i = 1; i < size - 1; i++) {
            int energy = arr.get(i - 1) * arr.get(i + 1);
            int removed = arr.remove(i);
            dfs(arr, size - 1, currentResult + energy);
            arr.add(i, removed);
        }
    }
}
