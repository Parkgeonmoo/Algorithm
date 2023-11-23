
import java.io.*;
import java.util.*;
public class Main {
    public static int N;
    public static int[] parent;
    public static int[][] map;
    public static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static int totalLength = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        map = new int[N+1][N+1];
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tempc = st.nextToken().toCharArray();
            for (int j = 0; j < N; j++) {
                int temp = 0;
                if (tempc[j] >= 'a' && tempc[j] <= 'z')
                    temp = tempc[j] - 'a' + 1;
                else if (tempc[j] >= 'A' && tempc[j] <= 'Z')
                    temp = tempc[j] - 'A' + 27;
                totalLength = totalLength + temp;
                if (i != j && temp != 0) {
                    pq.add(new Edge(i, j, temp));
                }
            }
        }

        int useEdge = 0;
        int result = 0;

        while (!pq.isEmpty()) { // 최소 신장 트리 알고리즘을 수행하여 줍니다.
            Edge now = pq.poll();
            if (find(now.start) != find(now.end)){ // 같은 부모가 아니라면 -> 연결 가능
                union(now.start, now.end);
                result = result + now.value;
                useEdge++;
            }
        }
        if (useEdge == N - 1) System.out.println(totalLength - result);
        else System.out.println(-1);











    }
    public static void union(int a,int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int num) {
        if (parent[num] == num) {
            return num;
        }
        else {
            return parent[num] = find(parent[num]);
        }
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int value;

    public Edge(int start,int end,int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }


    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}