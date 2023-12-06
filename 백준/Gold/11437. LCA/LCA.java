
import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int[] parent;
    public static int[] depth;
    public static ArrayList<Integer>[] tree;
    public static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parent = new int[N+1];
        depth = new int[N+1];
        tree = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }

        BFS(1);

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = executeLCA(a,b);
            System.out.println(result);
        }





    }
    public static void BFS(int num) {
        Queue<Integer> q = new LinkedList<>();
        int depthLevel = 1; // 트리 깊이
        int count = 0; //현재 같은 트리 높이인지 체크용
        int nowSize = 1; //현재 큐에 들어간 크기
        visited[num] = true;
        parent[num] = 0;
        depth[num] = 0;
        q.add(num);

        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (int nextNode : tree[nowNode]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    parent[nextNode] = nowNode;
                    depth[nextNode] = depthLevel;
                    q.add(nextNode);
                }
            }
            count++;

            if (count == nowSize) {
                count = 0;
                nowSize = q.size();
                depthLevel++;
            }

        }



    }

    public static int executeLCA(int a,int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (depth[a] != depth[b]) {
            a = parent[a];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
