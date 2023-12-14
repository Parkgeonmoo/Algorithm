import java.util.Scanner;

public class Main{

    static long mod = 10007;
    public static void main(String[]args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();


        long[] map = new long[1001];
        map[1] = 1;
        map[2] = 2;


        for (int i = 3; i <= N; i++) {
            map[i] =(map[i-1] + map[i-2]) % mod;

        }
        System.out.println(map[N]);


    }
}