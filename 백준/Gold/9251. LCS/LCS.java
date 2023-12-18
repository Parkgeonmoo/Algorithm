
import java.io.*;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();


        int[][] D = new int[aArray.length + 1][bArray.length + 1];

        for (int i = 1; i <= aArray.length; i++) {
            for (int j = 1; j <= bArray.length; j++) {
                if (aArray[i -1] == bArray[j -1]) {
                    D[i][j] = D[i-1][j-1] + 1;
                }
                else {
                    D[i][j] = Math.max(D[i][j-1] , D[i-1][j]);
                }
            }
        }

        System.out.println(D[aArray.length][bArray.length]);

    }
}