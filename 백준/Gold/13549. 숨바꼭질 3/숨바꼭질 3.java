import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        bfs(N);

    }

    public static void bfs(int start) {
        Queue<find> q = new LinkedList<>();
        q.offer(new find(start, 1));
        visited[start] = 1;

        while (!q.isEmpty()) {
            find temp = q.poll();
            if(temp.x+1>=0 && temp.x+1<=100000) {
                if (visited[temp.x + 1] == 0 || visited[temp.x + 1] > temp.count + 1) {
                    visited[temp.x + 1] = temp.count + 1;
                    q.offer(new find(temp.x + 1, temp.count + 1));
                }
            }
            if(temp.x-1>=0 && temp.x-1<=100000) {
                if (visited[temp.x-1] == 0 || visited[temp.x-1] > temp.count+1) {
                    visited[temp.x - 1] = temp.count + 1;
                    q.offer(new find(temp.x - 1, temp.count + 1));
                }
            }
            if(temp.x*2>=0 && temp.x*2<=100000) {
                if (visited[temp.x*2] == 0 || visited[temp.x*2] > temp.count) {
                    visited[temp.x * 2] = temp.count;
                    q.offer(new find(temp.x * 2, temp.count));
                }
            }
        }
        System.out.println(visited[K]-1);

    }

}

class find {
    int x;
    int count;

    public find(int x, int count) {
        this.x = x;
        this.count = count;
    }
}
