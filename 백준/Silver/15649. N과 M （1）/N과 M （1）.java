import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    
    static int[] result;
    static int N;
    static int M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        result = new int[M];
        visited = new boolean[N+1];

        find (0,0);
        System.out.println(sb.toString());




    }

    public static void find(int depth,int index) {

        if (depth == M) {
            for (int temp : result) {
                sb.append(temp +" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result[index] = i;
                visited[i] = true;
                find(depth + 1, index + 1);
                visited[i] = false;
            }
        }
    }






}