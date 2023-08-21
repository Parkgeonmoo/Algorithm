import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arraylist;
    static boolean[] dfsvisited;
    static boolean[] bfsvisited;
    static int N,M,V;
    static StringBuilder dfsbuilder = new StringBuilder();
    static StringBuilder bfsbuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arraylist = new ArrayList[N+1];
        dfsvisited = new boolean[N+1];
        bfsvisited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            arraylist[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            arraylist[vertex].add(edge);
            arraylist[edge].add(vertex);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arraylist[i]);
        }
        
        dfs(V);
        bfs(V);


        System.out.println(dfsbuilder.toString());
        System.out.println(bfsbuilder.toString());






    }
    public static void dfs(int start) {
        dfsvisited[start] = true;
        dfsbuilder.append(start + " ");
        for (int i : arraylist[start]) {
             if (!dfsvisited[i]) {
                 dfsvisited[i] = true;
                 dfs(i);
                }

        }

    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        bfsvisited[start] = true;
        bfsbuilder.append(start + " ");
        queue.offer(start);

        while (!queue.isEmpty()) {
            int check  = queue.poll();
            for (int i : arraylist[check]) {
                if (!bfsvisited[i]) {
                    bfsvisited[i] = true;
                    bfsbuilder.append(i + " ");
                    queue.add(i);
                }
            }

        }
    }
}
