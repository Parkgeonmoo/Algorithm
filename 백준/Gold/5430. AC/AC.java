
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();

            String[] nums = array.substring(1, array.length() - 1).split(",");

            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(nums[i]));
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char command : commands.toCharArray()) {
                if (command == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
