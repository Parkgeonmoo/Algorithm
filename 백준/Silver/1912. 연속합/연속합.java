
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] L = new int[N+1];

        int[] num = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        L[1] = num[1];
        int result = L[1];

        for (int i = 2; i <= N; i++) {
            L[i] = Math.max(num[i],L[i-1] + num[i]);
            result = Math.max(result,L[i]);
        }

        System.out.println(result);







    }
}