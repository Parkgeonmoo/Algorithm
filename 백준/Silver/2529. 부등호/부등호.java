import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int K;
    public static int[] arr = new int[10];
    public static char[] signs;

    public static String max = "";
    public static String min = "";

    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine().trim());

        signs = new char[K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        visited = new boolean[10];
        dfs(0, "");

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, String num) {
        if (depth == K + 1) {
            if (min.equals("") || Long.parseLong(num) < Long.parseLong(min)) {
                min = num;
            }
            if (max.equals("") || Long.parseLong(num) > Long.parseLong(max)) {
                max = num;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth == 0 || check(num.charAt(depth - 1) - '0', i, signs[depth - 1])) {
                    visited[i] = true;
                    dfs(depth + 1, num + i);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean check(int a, int b, char sign) {
        if (sign == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }
}
