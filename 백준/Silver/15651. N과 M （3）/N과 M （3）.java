import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int [] arr;
    static int N;
    static int M;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        find(0);
        System.out.println(sb.toString());



    }

    public static void find(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            find(depth+1);
        }
    }
}
