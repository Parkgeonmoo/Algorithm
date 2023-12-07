
import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            map = new int[M+1][M+1];

            map[0][0] = 1;

            for (int j = 1; j < M+1; j++) {
                map[j][1] = j;
                map[j][0] = 1;
                map[j][j] = 1;
            }

            for (int j = 1; j < M+1; j++) {
                for (int k = 1; k < M+1; k++) {
                    map[j][k] = map[j-1][k-1] + map[j-1][k];
                }
            }

            System.out.println(map[M][N]);



        }





    }
}
