import java.util.*;

public class Main{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int [] arr = new int[M];
        LinkedList<Integer> deque = new LinkedList<>();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        for (int i = 0; i < M; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < M; i++) {

            int targetIndex = deque.indexOf(arr[i]);
            int halfIndex;

            if (deque.size() % 2 == 0) {
                halfIndex = deque.size()/2 -1;
            }else{
                halfIndex = deque.size()/2;
            }

            if (targetIndex <= halfIndex) {
                for (int j = 0; j < targetIndex; j++) {
                    int temp = deque.pollFirst();
                    deque.add(temp);
                    count++;
                }
            }
            else {
                for (int j = 0; j <deque.size() -targetIndex; j++) {
                    int temp = deque.pollLast();
                    deque.addFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);

    }
}