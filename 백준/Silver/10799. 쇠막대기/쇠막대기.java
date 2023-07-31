import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if (s.charAt(i - 1) == '(') { // 레이저일 경우
                    sum += stack.size(); // 현재 존재하는 여는 괄호의 개수만큼 막대기를 자름
                } else { // 쇠막대기의 끝인 경우
                    sum++; // 막대기 하나가 끝났으므로 개수를 1 증가
                }
            }
        }

        System.out.println(sum);
    }
}
