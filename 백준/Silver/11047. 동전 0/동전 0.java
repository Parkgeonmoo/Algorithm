
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] coins = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }




        for (int i = coins.length - 1; i >= 0; i--) {
            int coinPrice = coins[i];
            int nowCount = 0;
            if (coinPrice <= K) {
                count += K / coinPrice;
                nowCount = K /coinPrice;
                K -= nowCount * coinPrice;
            } else {
                continue;
            }
        }
        System.out.println(count);



    }
}