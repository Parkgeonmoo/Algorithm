import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int answer = 0;
    static int[]result;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = new int[M];
        visited = new boolean[N+1];

        find(0,N,M);


    }
    public static void find(int depth,int N,int M) {
        if (depth == M) {
            for (int temp : result) {
                System.out.print(temp + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                find(depth+1,N,M);
                visited[i] = false;
            }
        }
    }

    }





