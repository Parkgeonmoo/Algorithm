import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    static int L,N,R;
    static long[][][] map;
    static long mod = 1000000007;

    public static void main(String[]args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new long[101][101][101];

        map[1][1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    map[i][j][k] = (map[i-1][j][k] * (i-2) + (map[i-1][j][k-1] + map[i-1][j-1][k]))% mod;
                }
            }
        }
        System.out.println(map[N][L][R]);





    }
}