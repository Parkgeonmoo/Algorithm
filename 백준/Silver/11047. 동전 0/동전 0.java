import java.util.*;

public class  Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[]A = new int[N];
        for (int i = 0; i < N; i++){
            A[i] = in.nextInt();
        }
        int count = 0;
        for (int i = N-1; i >= 0; i--){
            if(A[i] <= K){
                count += (K / A[i]);
                K = K % A[i];
            }
        }
        System.out.println(count);
    }

}