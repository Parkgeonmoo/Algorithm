import java.util.Scanner;

public class Main{

    public static void main(String[]args) {

        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int N = in.nextInt();
        int[] map = new int[K];
        long max = 0;
        long min = 0;

        for (int i = 0; i < K; i++) {
            map[i] = in.nextInt();
            max = Math.max(max,map[i]);
        }
        max++;

        while (min < max) {
            long mid = (min+max)/2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += (map[i]/mid);
            }
            if (count < N){
                max = mid;
            }
            else{
                min = mid+1;
            }

        }
        System.out.println(min-1);

    }
}