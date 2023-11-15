
import java.util.*;
import java.io.*;

public class Main{
    public static int[] result;
    public static boolean[] visited;
    public static ArrayList<Edge>[] map;

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        result = new int[V+1];
        visited = new boolean[V+1];
        map = new ArrayList[V+1];

        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<Edge>();
        }
        PriorityQueue<Edge> q = new PriorityQueue<Edge>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[u].add(new Edge(v,w));
        }
        for (int i = 0; i <= V; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        q.add(new Edge(K,0));
        result[K] = 0;

        while (!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;
            if (visited[c_v]) continue;
            visited[c_v] = true;
            for (int i = 0; i < map[c_v].size(); i++) {
                Edge tmp = map[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if (result[next] > result[c_v] + value) {
                    result[next] = value + result[c_v];
                    q.add(new Edge(next,result[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++){
            if (visited[i])
                System.out.println(result[i]);
            else
                System.out.println("INF");
        }


    }
}
class Edge implements Comparable<Edge>{
    int vertex;
    int value;
    public Edge(int vertex,int value) {
        this.vertex = vertex;
        this.value = value;
    }
    public int compareTo(Edge e) {
        if (this.value > e.value) return 1;
        else return -1;
    }
}