
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();

            if (temp.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            }
            else if (temp.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            }
            else if (temp.equals("pop_front")) {
                if (deque.size() > 0) {
                    System.out.println(deque.pollFirst());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if (temp.equals("pop_back")) {
                if (deque.size() > 0) {
                    System.out.println(deque.pollLast());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if (temp.equals("size")) {
                System.out.println(deque.size());
            }
            else if (temp.equals("empty")) {
                if (!deque.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(1);
                }
            }
            else if (temp.equals("front")) {
                if (deque.size() > 0) {
                    System.out.println(deque.peekFirst());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if (temp.equals("back")) {
                if (deque.size() > 0) {
                    System.out.println(deque.peekLast());
                }
                else {
                    System.out.println(-1);
                }
            }
        }

    }
}
