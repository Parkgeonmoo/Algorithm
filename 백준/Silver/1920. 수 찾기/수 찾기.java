import java.util.*;

public class  Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] A = new int[N];
        for (int i = 0; i < N; i++){
            A[i] = in.nextInt();
        }
        Arrays.sort(A);
        int M = in.nextInt();
        for (int i = 0; i < M; i++){
            boolean find = false;
            int target = in.nextInt();
            int start = 0;
            int end = A.length-1;
            while(start <= end) {
                int midi = (start+end)/2;
                int midv = A[midi];
                if(midv > target) {
                    end = midi - 1;

                } else if (midv < target) {
                    start = midi + 1;
                }else{
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }
}