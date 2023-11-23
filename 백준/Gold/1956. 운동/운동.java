
import java.util.*;
import java.io.*;

public class Main {
    public static int V, E;
    public static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V+1][V+1];

        for (int i = 0; i <= V; i++) {
            for (int j = 0; j <= V; j++) {
                if  (i == j) {
                    map[i][j] = 0;
                }else{
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map[start][end] = value;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j && map[i][j] != Integer.MAX_VALUE && map[j][i] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, map[i][j] + map[j][i]);
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }









    }
}