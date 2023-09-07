import java.util.Scanner;
import java.util.Arrays;
public class Main{

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] map = new int[N];
        int[] check = new int[N];


        for (int i = 0; i < N; i++) {
            map[i] = in.nextInt();
        }
        Arrays.sort(map);

        check[0] = map[0];
        int sum = check[0];
        for (int i = 1; i < N; i++) {
            check[i] = check[i-1] + map[i];
            sum += check[i];
        }
        


        System.out.println(sum);
            }
}