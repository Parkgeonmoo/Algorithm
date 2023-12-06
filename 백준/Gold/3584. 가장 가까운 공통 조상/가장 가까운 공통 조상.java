
import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int[] parent;
    public static int[] depth;
    public static ArrayList<Integer>[] tree;
    public static int N,T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N+1];
            parent = new int[N+1];
            depth = new int[N+1];
            tree = new ArrayList[N+1];

            for (int q = 0; q <= N; q ++) {
                tree[q] = new ArrayList<Integer>();
            }

            for (int j = 0; j < N - 1; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                tree[start].add(end);
                tree[end].add(start);
                parent[end] = start;
            }

            int root = 0;

            for (int k = 1; k < parent.length; k++) {
                if (parent[k] == 0) {
                    root = k;
                    break;
                }
            }
            BFS(root);

            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            int result = executeLCA(startIndex,endIndex);
            System.out.println(result);


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

    public static void BFS(int root) {
        Queue<Integer> q = new LinkedList<>();
        visited[root] = true;
        depth[root] = 0;
        int count = 0;
        int depthLevel = 1;
        int nowSize = 1;
        q.add(root);

        while (!q.isEmpty()) {
            int nowNode = q.poll();

            for (int nextNode : tree[nowNode]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
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
}
