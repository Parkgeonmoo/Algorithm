import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Stack<Integer>[] stack = new Stack[7]; // 줄 번호가 1부터 시작하므로 7로 설정
        for (int i = 1; i <= 6; i++) {
            stack[i] = new Stack<>();
        }
        int count = 0;

        for (int i = 0; i < N; i++) {
            int line = in.nextInt();
            int fret = in.nextInt();

            while (!stack[line].isEmpty() && stack[line].peek() > fret) {
                stack[line].pop();
                count++;
            }

            if (!stack[line].isEmpty() && stack[line].peek() == fret) {
                continue;
            }

            stack[line].push(fret);
            count++;
        }

        System.out.println(count);
    }
}
