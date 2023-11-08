
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<city>[] map;
    public static boolean[] visited;
    public static int N,M,K,X;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static boolean isAvailable = false;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<city>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A].add(new city(B,0));
        }

        BFS(X);

        if (isAvailable) {
            Collections.sort(answer);
            for (int i : answer){
                System.out.println(i);
            }
        }
        else {
            System.out.println(-1);
        }



    }
    public static void BFS(int start) {
        Queue<city> q = new LinkedList<>();
        q.add(new city(start,0));
        visited[start] = true;

        while (!q.isEmpty()) {
            city temp = q.poll();

            if (temp.dis == K) {
                answer.add(temp.end);
                isAvailable = true;
            }

            if (temp.dis >= K) {
                continue;
            }

            for (city next : map[temp.end]) {
                if (!visited[next.end]) {
                    visited[next.end] = true;
                    q.add(new city(next.end,temp.dis+1));
                }
            }
        }
    }

    public static class city {
        int end;
        int dis;

        public city(int end,int dis) {
            this.end = end;
            this.dis = dis;
        }
    }
}
