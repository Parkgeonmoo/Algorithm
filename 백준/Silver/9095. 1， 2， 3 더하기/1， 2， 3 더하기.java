import java.util.Scanner;

public class Main{

    static int t;
    static int [] map = new int[11];

    public static void main(String[]args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        map[1] = 1;
        map[2] = 2;
        map[3] = 4;

        for (int i = 4; i <= 10; i++) {
            map[i] = map[i-1] +map[i-2] + map[i-3];
        }
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
        System.out.println(map[n]);
        }

    }



}