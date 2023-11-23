
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static boolean[]visited;
    public static ArrayList<Integer>[] list;
    public static int root;
    public static int answer = 0;
    public static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp != -1) {
                list[i].add(temp);
                list[temp].add(i);
            }
            else {
                root = i;
            }
        }
        T = Integer.parseInt(br.readLine());
        if (T == root) {
            System.out.println(0);
        }
        else {
            DFS(root);
            System.out.println(answer);

        }


    }
    public static void DFS(int num) {
        visited[num] = true;
        int leafNode = 0;
        for (int temp : list[num]) {
            if (!visited[temp] && temp != T) {
                leafNode++;
                DFS(temp);
            }
        }
        if (leafNode == 0) {
            answer++;
        }
    }


}