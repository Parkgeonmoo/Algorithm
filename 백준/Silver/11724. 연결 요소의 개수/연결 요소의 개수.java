import java.util.*;
import java.io.*;

public class Main{
    public static ArrayList<Integer>[] map;
    public static boolean[] visited;
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        visited = new boolean[N+1];
        int count = 0;
        
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s].add(e);
            map[e].add(s);
        }
        
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
        
    }
    public static void DFS(int C) {
        if (visited[C]) {
            return;
        }
        visited[C] = true;
        for (int i : map[C]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}