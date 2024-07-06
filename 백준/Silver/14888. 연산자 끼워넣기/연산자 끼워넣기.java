import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int [] arr;
    static int [] oper = new int[4];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0],1);
        System.out.println(MAX);
        System.out.println(MIN);

    }
    public static void dfs(int result,int depth) {
        if (depth == N) {
            MAX = Integer.max(MAX,result);
            MIN = Integer.min(MIN,result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                int nextresult = operation(result, arr[depth], i);
                dfs(nextresult, depth + 1);
                oper[i]++;
            }
        }
    }
    public static int operation(int a,int b,int operation) {

        if (operation == 0) {
           return a + b;

        }
        else if (operation == 1) {
            return  a - b;

        }
        else if (operation == 2) {
            return a * b;

        }
        else if (operation == 3) {
            return a / b;

        }else{
            return 0;
        }

    }
}


