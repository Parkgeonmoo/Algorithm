
import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Integer>[] num;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        num = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            num[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            num[s].add(e);
            num[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(num[i]);
        }

        DFS(V);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        visited = new boolean[N+1];
        BFS(V);
        System.out.println(sb.toString());



    }

    public static void DFS(int start) {
        sb.append(start + " ");
        visited[start] = true;

        for (int i : num[start]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList();
        visited[start] = true;
        sb.append(start+ " ");
        q.add(start);

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i : num[temp]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    sb.append(i + " ");
                }
            }
        }
    }





}
