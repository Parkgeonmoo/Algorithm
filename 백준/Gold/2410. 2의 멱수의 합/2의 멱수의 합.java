
import java.util.Scanner;

public class Main{
   public static int[] D;
    static double ans;
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        D = new int[N+1];

        D[0] = 1;
        D[1] = 1;

        for (int i = 2; i <= N; i++) {
            D[i] = (D[i-2] + D[i / 2]) % 1000000000;
        }

        System.out.println(D[N]);


    }
}
