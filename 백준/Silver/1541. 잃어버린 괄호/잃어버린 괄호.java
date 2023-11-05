
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str = s.split("-");
        int answer = 0;

        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);

            if (i == 0) {
                answer = answer + temp;
            }
            else {
                answer = answer - temp;
            }
        }

        System.out.println(answer);




















    }
    public static int mySum(String s) {
       int sum = 0;
       String [] temp = s.split("[+]");
       for (int i = 0; i < temp.length; i++) {
           sum += Integer.parseInt(temp[i]);
       }
       return sum;
    }
}