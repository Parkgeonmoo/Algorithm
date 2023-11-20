import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        for (int i =1 ; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = 1000001;
            }
        }
        for (int i  =1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s][e] = 1;
            map[e][s] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }
        int Min = Integer.MAX_VALUE;
        int Answer = -1;

        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= N; j++) {
                temp = temp +map[i][j];
            }
            if (Min > temp) {
                Min  = temp;
                Answer = i;
        }

        }
        System.out.println(Answer);

    }
}