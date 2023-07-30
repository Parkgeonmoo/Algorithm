import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] c = s.toCharArray();
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
                sb.append(c[i]);
            } else if (c[i] == '>') {
                flag = false;
                sb.append(c[i]);
            } else {
                if (flag) {
                    sb.append(c[i]);
                } else {
                    if (c[i] == ' ') {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(c[i]);
                    } else {
                        stack.push(c[i]);
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
