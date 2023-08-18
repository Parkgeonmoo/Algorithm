import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       N = Integer.parseInt(br.readLine());
       numbers = new int[N];

       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < N; i++) {
           numbers[i] = Integer.parseInt(st.nextToken());
       }

       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < 4; i++) {
           operators[i] = Integer.parseInt(st.nextToken());
       }

       dfs(1,numbers[0]);
       System.out.println(maxResult);
       System.out.println(minResult);
    }

    public static void dfs(int index,int result) {
        if (index == N) {
            maxResult = Math.max(maxResult,result);
            minResult = Math.min(minResult,result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0 ){
                operators[i]--;
                int nextresult = Calc(result,numbers[index],i);
                dfs(index+1,nextresult);
                operators[i]++;
            }
        }
    }

    public static int Calc(int a,int b,int operation) {
        if (operation == 0) {
            return a + b;
        }
        else if (operation == 1) {
            return a - b;
        }
        else if (operation == 2) {
            return a * b;
        }
        else if (operation == 3) {
            return a / b;
        }
        else {
            return 0;
        }
    }
}
