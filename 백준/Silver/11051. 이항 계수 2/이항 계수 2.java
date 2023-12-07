
import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];


        for (int i = 0; i <= N; i++) {
            map[i][i] = 1;
            map[i][0] = 1;
            map[i][i] = i;
        }


        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = (map[i-1][j] + map[i-1][j-1]) % 10007;
            }
        }

        System.out.println(map[N][K]);






    }
}
