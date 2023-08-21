import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arraylist;
    static int N;
    static int[] result;
    static StringBuilder dfsbuilder = new StringBuilder();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        arraylist = new ArrayList[N+1];
        result = new int[N+1];

        for (int i = 0; i <= N; i++) {
            arraylist[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            arraylist[vertex].add(edge);
            arraylist[edge].add(vertex);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            dfsbuilder.append(result[i]+"\n");
        }

        System.out.println(dfsbuilder.toString());




    }
    public static void dfs(int start) {
        visited[start] = true;

        for (int i : arraylist[start]) {
            if (!visited[i]) {
                if(result[i] == 0) {
                    result[i] = start;
                    visited[i] = true;
                    dfs(i);
                }
            }
        }
    }
}
