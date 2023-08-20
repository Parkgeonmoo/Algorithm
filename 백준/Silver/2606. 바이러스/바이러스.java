import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] computer;
    static boolean [] visited;
    static int N, M;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        computer = new ArrayList[N+1]; // 배열 초기화
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            computer[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            computer[index].add(value);
            computer[value].add(index);
        }


        bfs(1);
        System.out.println(answer);



    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
                visited[now] = true;
                for (int i : computer[now]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        answer++;
                        queue.add(i);
                    }
                }

        }
    }
}
