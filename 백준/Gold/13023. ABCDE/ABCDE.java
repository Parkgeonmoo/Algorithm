import java.util.*;
import java.io.*;

public class Main{
    public static boolean visited[];
    public static boolean arrive;
    public static ArrayList<Integer>[] map;
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arrive =false;
        map = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i <M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i,1);
            if (arrive) {
                break;
            }
        }

        if (arrive)
            System.out.println("1");
        else
            System.out.println("0");

    }
    public static void DFS(int v,int depth) {
        if (depth == 5){
            arrive = true;
            return;
        }

        visited[v] = true;
        for (int i : map[v]){
            if (!visited[i]) {
                DFS(i,depth+1);
            }
        }
        visited[v] = false;
    }
}