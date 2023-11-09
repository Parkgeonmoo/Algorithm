import java.util.Scanner;

public class Main{
    static int N,K;
    static int [][] map;
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();
        map = new int[11][11];

        for (int i = 0; i <= N; i++) {
            map[i][i] = 1;
            map[i][0] = 1;
            map[i][1] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                map[i][j] = map[i-1][j] + map[i-1][j-1];
            }

        }
        System.out.println(map[N][K]);


    }
}