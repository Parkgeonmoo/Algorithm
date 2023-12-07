
import java.util.Scanner;

public class Main {
    public static int[] D;
    static double ans;
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        D = new int[Math.max(N+1, 3)];

        D[0] = 0;
        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i <= N; i++) {
            D[i] = (D[i-2] + D[i -1]) % 15746;
        }

        System.out.println(D[N]);
    }
}
