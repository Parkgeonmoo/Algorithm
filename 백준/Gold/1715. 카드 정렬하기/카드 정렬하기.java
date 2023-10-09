import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;

public class Main{

    public static void main(String[]args) {

        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int N = in.nextInt();
        int[] map = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            map[i] = in.nextInt();
            queue.add(map[i]);
        }

        while(queue.size() != 1) {
            int value1 = queue.poll();
            int value2 = queue.poll();
            sum += value1 +value2;
            queue.add(value1+value2);

        }
        System.out.println(sum);


    }
}