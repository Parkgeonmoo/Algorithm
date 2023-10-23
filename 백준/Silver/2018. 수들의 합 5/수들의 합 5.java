import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;
        while (end != N) {
            if (sum == N) {
                end++;
                sum = sum + end;
                count++;
            } else if (sum > N) {
                sum = sum - start;
                start++;
            } else{
                end++;
                sum = sum + end;
            }
        }

        System.out.println(count);






    }


}