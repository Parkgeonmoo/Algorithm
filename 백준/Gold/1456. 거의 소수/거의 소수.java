import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        long A = in.nextLong();
        long B = in.nextLong();
        long[] map = new long[10000001];

        for (int i = 2; i < map.length; i++) {
            map[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(map.length); i++) {
            if (map[i] == 0) {
                continue;
            }
            for (int j = i+i; j < map.length; j = j+i) {
                map[j] = 0;
            }
        }

        int count = 0;

        for (int i = 2; i < map.length; i++) {
            if (map[i] != 0) {
                long temp = map[i];
                while ((double) map[i] <= (double) B / (double) temp) {
                    if ((double) map[i] >= (double) A / (double) temp) {
                        count++;
                    }
                    temp = temp * map[i];
                }
            }
        }
        System.out.println(count);


    }
}