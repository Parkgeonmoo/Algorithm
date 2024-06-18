import java.util.Scanner;

public class Main{

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int start = 0;
        int end = -1;
        int[] map = new int[N];

        for (int i = 0; i < N; i++) {
            map[i] = in.nextInt();
            end = Math.max(end,map[i]);
        }

        int M = in.nextInt();

        while (start <= end) {
            int mid = (start+end)/2;
            long budget = 0;

            for (int i = 0; i < N; i++) {
                if (map[i] > mid) {
                    budget += mid;
                } else {
                    budget += map[i];

                }
            }
            if (budget <= M) {
                start = mid + 1;
            }
            else{
                end = mid -1;
            }



        }
        System.out.println(end);



    }
}