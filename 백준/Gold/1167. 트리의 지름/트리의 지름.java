import java.util.*;
import java.io.*;

public class Main{
    public static int[] distance;
    public static ArrayList<Node>[] map;
    public static boolean[] visited;

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        map = new ArrayList[N+1];


        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<Node>();
        }
        for (int i = 1; i <= N; i++) {
            int S = in.nextInt();
            while (true) {
                int E = in.nextInt();
                if (E == -1) {
                    break;
                }
                int V = in.nextInt();
                map[S].add(new Node(E,V));
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(1);
        int Max = 1;

        for (int i = 2; i <= N; i++) {
            if(distance[Max] < distance[i]) {
                Max = i;
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);



    }
    public static class Node{
        int node;
        int value;
        Node(int node,int value) {
            this.node = node;
            this.value = value;
        }
    }
    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for (Node i : map[now]) {
                int N = i.node;
                int V = i.value;
                if (!visited[N]) {
                    visited[N] = true;
                    queue.add(N);
                    distance[N] = distance[now] + V;
                }

            }
        }
    }
}