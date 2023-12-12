import java.util.*;

public class Main{

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] map = new long[1000001];
        long mod = 1000000000;
        map[1] = 0;
        map[2] = 1;

        for (int i = 3; i <= N; i++) {
            map[i] = (i-1) * (map[i-1] +map[i-2]) % mod;
        }
        System.out.println(map[N]);
    }
}