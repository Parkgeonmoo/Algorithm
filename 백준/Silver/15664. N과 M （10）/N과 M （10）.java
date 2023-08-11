import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean visited[];
    static int[] arr;
    static int[] result;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[]args) throws IOException{
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


        find(0,0);
        System.out.println(sb.toString());

    }

    public static void find(int depth,int index) {
        if (depth == M) {
            for (int temp : result) {
                sb.append(temp + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;


        for (int i = index; i < N; i++) {
            if (!visited[i]  && (prev == -1 || prev != arr[i])) {
                result[depth] = arr[i];
                visited[i] = true;
                find(depth+1,i+1);
                visited[i] = false;
                prev = arr[i];
            }
        }
    }




}