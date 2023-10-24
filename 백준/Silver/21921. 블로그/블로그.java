import java.util.*;
import java.io.*;

public class Main {
    public static int total;
    public static int max;
    public static int[] daynum;
    public static int[] day;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        day = new int[N];
        daynum = new int[X];
        max = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(st.nextToken());
            if(i < X){
                total += day[i];
            }

            if(i == X-1){
                max=total;
                count=1;
            }

            if(i >= X){
                Add(day[i]);
                Remove(day[i-X]);

                if(total > max){
                    max=total;
                    count=1; // Reset the count when we find a new maximum
                } else if(total == max){
                    count++; // Increase the count when we find an equal maximum
                }

            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else{
            System.out.println(max);
            System.out.println(count);
        }


    }

    public static void Add(int num) {
         total += num;
    }

    public static void Remove(int num) {
        total -= num;
    }
}