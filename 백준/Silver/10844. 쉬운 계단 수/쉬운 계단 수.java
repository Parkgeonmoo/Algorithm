import java.util.Scanner;

public class Main{
    static long mod = 1000000000;

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        long[][] map = new long[N+1][10];

        for (int i = 1; i <= 9; i++) {
            map[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0) {
                    map[i][j] = map[i-1][j+1] % mod;
                }
                else if (j == 9) {
                    map[i][j] = map[i-1][j-1] % mod;
                }
                else{
                    map[i][j] = (map[i-1][j-1] + map[i-1][j+1]) % mod;
                }
            }

        }
        long result = 0;

        for (int i = 0; i < 10; i++) {
            result += map[N][i];

        }
        System.out.println(result % mod);
    }
}