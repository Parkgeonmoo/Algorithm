import java.io.*;
import java.util.*;

public class Main{
    public static int[]result;

    public static void main(String[]args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        result = new int[V+1];

        for (int i = 0; i < V; i++) {
            result[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            queue.add(new Edge(A,B,C));
        }
        int useEdge = 0;
        int total = 0;
        while (useEdge < V-1) {
            Edge now = queue.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start,now.end);
                total = total+now.weight;
                useEdge++;
            }
        }
        System.out.println(total);



    }
    public static void union(int a,int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            result[b] = a;
        }
    }
    public static int find(int a) {
        if (a == result[a]) {
            return a;
        }else{
            return result[a] = find(result[a]);
        }
    }
}
class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;
    public Edge(int start,int end,int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}