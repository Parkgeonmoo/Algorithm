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
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       arr = new int[N];
       visited = new boolean[N];
       result = new int[M];
       st = new StringTokenizer(br.readLine());

       for (int i = 0; i < N; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
       } // 4 5 2 입력

       Arrays.sort(arr); // 2 4 5 정렬
       find(arr,0,M); //함수 시작
       System.out.println(sb.toString());




    }

    public static void find(int[] arr ,int depth,int M){
        if (depth == M) {
            for (int temp : result) {
                sb.append(temp + " ");
            }
            sb.append("\n");
            return;
        } // 종료 조건

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                find(arr,depth+1,M);
                visited[i] = false;
            }

        }


    }
}
