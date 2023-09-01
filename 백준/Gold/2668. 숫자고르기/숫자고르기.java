import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{

    static int[] arr;
    static boolean[] visited;
    static int last;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            last = i;
            bfs(i);
        }

        System.out.println(list.size());

        for (int i : list) {
            System.out.println(i);
        }



    }
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (!visited[arr[temp]]) {
                visited[arr[temp]] = true;
                q.offer(arr[temp]);
                if (arr[temp] == last) {
                    list.add(arr[temp]);
                }
            }

        }
    }
}