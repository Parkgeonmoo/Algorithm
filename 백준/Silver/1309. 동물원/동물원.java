
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] D = new int[N+1][3];

        Arrays.fill(D[1],1);

        for (int i = 2; i <= N; i++) {
            D[i][0] = (D[i-1][0] + D[i-1][1] + D[i-1][2]) % 9901;
            D[i][1] = (D[i-1][2] + D[i-1][0]) % 9901;
            D[i][2] = (D[i-1][1] + D[i-1][0]) % 9901;
        }

        int result = 0;

        for (int i = 0; i < 3; i++) {
            result += D[N][i];
        }

        System.out.println(result % 9901);
    }
}