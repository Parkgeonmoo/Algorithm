import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("push")) {
                int temp = Integer.parseInt(command[1]);
                stack.push(temp);
            } else if (command[0].equals("top")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            } else if (command[0].equals("size")) {
                System.out.println(stack.size());
            } else if (command[0].equals("empty")) {
                if (!stack.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (command[0].equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            }
        }

        br.close();
    }
}
