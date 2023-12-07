import java.util.Scanner;

public class Main{
    static int T,M,K;
    static double[] pro = new double[51];
    static int[] D = new int[51];
    static double ans;
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        T = 0;
        M = in.nextInt();
        for (int i = 0; i < M; i++) {
            D[i] = in.nextInt();
            T += D[i];
        }
        K = in.nextInt();
        ans = 0.0;
        for (int i = 0; i < M; i++) {
            if (D[i] >= K) {
                pro[i] = 1.0;
                for (int k = 0; k < K; k++) {
                    pro[i] *= (double)(D[i]-k) / (T-k);
                }
                ans +=pro[i];
            }

        }
        System.out.println(ans);

    }
}