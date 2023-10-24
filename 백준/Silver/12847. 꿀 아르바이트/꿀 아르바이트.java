
import java.util.*;
import java.io.*;

public class Main {
    public static long total;
    public static long max;
    public static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        money = new int[n];
        max = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            total += money[i];
        }

        max = Math.max(total,max);



        for (int i = m; i < n; i++) {
            int j = i - m;
            Add(money[i]);
            Remove(money[j]);
            max = Math.max(max,total);

        }

        System.out.println(max);



    }

    public static void Add(int num) {
        total += num;
    }

    public static void Remove(int num) {
        total -= num;
    }

}
