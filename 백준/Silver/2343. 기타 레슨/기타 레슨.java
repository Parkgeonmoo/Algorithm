import java.util.Scanner;

public class Main{
    static int N,M,start,end;
    static int[] map;

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        map = new int[N];
        start = 0;
        end = 0;

        for (int i = 0; i < N; i++) {
            map[i] = in.nextInt();
            start = Math.max(start,map[i]);
            end += map[i];

        }

        while(start<=end) {
            int mid = (start+end)/2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum+map[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum = sum + map[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > M) {
                start = mid+1;
            }
            else
                end = mid-1;


        }
        System.out.println(start);
    }
}