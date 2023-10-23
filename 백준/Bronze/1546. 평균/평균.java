import java.util.*;

public class Main{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double[] map = new double[N];
        double max = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            map[i] = in.nextInt();
            max = Math.max(max,map[i]);
        }
        for (int i = 0; i < N; i++) {
            map[i] = (map[i]/max) * 100;
            sum += map[i];

        }
        System.out.println(sum/N);


    }
}