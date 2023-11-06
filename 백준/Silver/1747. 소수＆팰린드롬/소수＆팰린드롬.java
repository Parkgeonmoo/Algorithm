
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[10000001];

        for (int i = 2; i < num.length; i++) {
            num[i] = i;
        }

        for (int i = 2; i < Math.sqrt(num.length); i++) {
            if (num[i] == 0) {
                continue;
            }
            for (int j = i + i; j < num.length; j = j + i) {
                num[j] = 0;
            }
        }
        int i = N;

        while (true) {
            if (num[i] != 0) {
                if (is_pallen(num[i])) {
                    System.out.println(num[i]);
                    break;
                }
            }
            i++;
        }




    }

    public static boolean is_pallen(int num) {
        char[] numArray = String.valueOf(num).toCharArray();
        int start = 0;
        int end = numArray.length-1;

        while (start < end) {
            if (numArray[start] != numArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}