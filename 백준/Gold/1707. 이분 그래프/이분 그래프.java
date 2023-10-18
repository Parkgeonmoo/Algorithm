import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static boolean[] visited;
    public static ArrayList<Integer>[] map;
    public static int[] check;
    public static boolean IsEven;
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());



        for (int t  = 0; t < N; t++) {
            String[] s = br.readLine().split(" ");
            int S = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            map = new ArrayList[S+1];
            visited = new boolean[S+1];
            check = new int[S+1];
            IsEven = true;
            for (int i = 1; i <= S; i++) {
                map[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                map[start].add(end);
                map[end].add(start);
            }
            for (int i = 1; i <= S; i++) {
                if(IsEven)
                    DFS(i);
                else
                    break;
            }
            if (IsEven)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
    public static void DFS(int node) {
        visited[node] = true;
        for (int i : map[node]) {
            if (!visited[i]) {
                check[i] = (check[node]+1) % 2;
                DFS(i);
            }
            else if (check[node] == check[i]){
                IsEven = false;
            }
        }
    }
}