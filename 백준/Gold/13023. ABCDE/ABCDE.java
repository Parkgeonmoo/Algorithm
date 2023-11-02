
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] num;
    public static boolean[] visited;
    public static boolean flag = false;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        num = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            num[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            num[a].add(b);
            num[b].add(a);
        }


        for (int i = 0; i < N; i++) {
                DFS(i,1);
                if (flag) {
                    break;
                }

        }

        if (flag) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }

    }

    public static void DFS(int start,int length) {
        if (length == 5) {
            flag = true;
            return;
        }
        visited[start] = true;

        for (int i : num[start]) {
            if (!visited[i]) {
                DFS(i,length+1);
            }
        }
        visited[start] = false;

    }


}
