import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;
public class Main{

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zero = 0;
        int one = 0;
        int N = in.nextInt();


        for (int i = 0; i < N; i++) {
            int data = in.nextInt();
            if (data > 1) {
                plus.add(data);
            }
            else if(data < 0) {
                minus.add(data);
            }else if (data == 0) {
                zero++;
            }
            else{
                one ++;
            }
        }
        int sum = 0;

        while(plus.size() > 1) {
            int first = plus.remove();
            int second = plus.remove();
            sum = sum+ first*second;
        }
        if (!plus.isEmpty()) {
            sum = sum +plus.remove();
        }
        while (minus.size() >1) {
            int first = minus.remove();
            int second = minus.remove();
            sum = sum +first*second;
        }
        if (!minus.isEmpty()) {
           if (zero == 0) {
               sum = sum +minus.remove();
           }
        }
        sum = sum +one;
        System.out.println(sum);



    }
}