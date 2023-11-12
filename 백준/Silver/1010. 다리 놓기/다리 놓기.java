import java.util.Scanner;

public class Main{
    static int T;
    static int[][] bridge;

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);

        bridge = new int[30][30];

       for (int i = 0 ; i < 30; i++) {
           bridge[i][i] = 1;
           bridge[i][0] = 1;
       }
       for (int i = 2; i < 30; i++){
           for (int j = 1; j < 30; j++) {
               bridge[i][j] = bridge[i-1][j] + bridge[i-1][j-1];
           }
       }
        T = in.nextInt();
       for (int i = 0; i < T; i++){
           int N = in.nextInt();
           int M = in.nextInt();
           System.out.println(bridge[M][N]);
       }


    }
}