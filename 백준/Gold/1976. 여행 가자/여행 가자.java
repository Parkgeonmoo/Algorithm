
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] parent;
    public static int[][] map;
    public static int[] root;
    public static boolean isOk = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        parent = new int[N+1];
        root = new int[M+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            root[i] = Integer.parseInt(st.nextToken());
        }

        int index = find(root[1]);
        for (int i = 2; i < root.length; i++) {
            if (index != find(root[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");







    }
    public static void union(int numOne,int numTwo) {
        numOne = find(numOne);
        numTwo = find(numTwo);

        if (numOne != numTwo) {
            parent[numTwo] = numOne;
        }
    }

    public static int find(int num) {
        if (parent[num] == num) {
            return num;
        }
        else {
            return parent[num] = find(parent[num]);
        }
    }
}
