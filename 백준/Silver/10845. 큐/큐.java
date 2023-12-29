
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
            String Line = st.nextToken();
            if (Line.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                deque.add(num);
            }
            else if (Line.equals("pop")) {
                if (deque.size() > 0) {
                    System.out.println(deque.pollFirst());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if (Line.equals("size")) {
                System.out.println(deque.size());
            }
            else if (Line.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if (Line.equals("front")) {
                if (deque.size() > 0) {
                    System.out.println(deque.peekFirst());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if (Line.equals("back")) {
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
