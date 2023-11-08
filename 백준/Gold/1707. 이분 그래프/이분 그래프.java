
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static int[]checked;
    public static boolean IsEven = true;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V+1];
            visited = new boolean[V+1];
            checked = new int[V+1];
            IsEven = true;

            for (int l = 0; l <= V; l++) {
                list[l] = new ArrayList<Integer>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list[u].add(v);
                list[v].add(u);

            }

            for (int k = 1; k <= V; k++) {
                if (IsEven) {
                    DFS(k);
                }
                else {
                    break;
                }
            }

            if (IsEven) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }

    }
    public static void DFS(int start) {
        visited[start] = true;

        for (int temp : list[start]) {
            if (!visited[temp]) {
                checked[temp] = (checked[start]+1) % 2;
                DFS(temp);
            }
            else if (checked[start] == checked[temp]){
                IsEven = false;
            }
        }
    }
}