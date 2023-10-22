import java.util.*;

public class Main{

    public static int[][] map;
    public static int[] route;
    public static int[] parent;

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        map = new int[N+1][N+1];


        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++) {
                map[i][j] = in.nextInt();
            }
        }

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        route = new int[M+1];
        for (int i = 1; i <= M; i++) {
            route[i] = in.nextInt();
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++){
                if (map[i][j] == 1) {
                    union(i,j);
                }

            }
        }
        int index = find(route[1]);
        for (int i = 2; i < route.length; i++) {
            if (index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
    public static void union(int i ,int j) {
        i = find(i);
        j = find(j);
        if (i != j) {
            parent[j] = i;
        }
    }
    public static int find(int i) {
        if (i == parent[i]){
            return i;
        }else{
            return parent[i] = find(parent[i]);
        }
    }

}