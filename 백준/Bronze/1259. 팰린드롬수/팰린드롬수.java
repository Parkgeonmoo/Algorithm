
import java.io.*;
import java.util.*;

public class Main {
    public static int T;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while ((T = in.nextInt()) != 0) {

            if (pallen(T)) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }

    }
    public static boolean pallen(int num) {
        String temp = String.valueOf(num);
        char[] changeTemp = temp.toCharArray();

        int start = 0;
        int end = changeTemp.length - 1;

        while (start < end) {
            if (changeTemp[start] == changeTemp[end]) {
                start++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}