import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String result = cursorcheck(N, br); // BufferedReader를 cursorcheck 메서드에 전달
        System.out.println(result);
    }

    public static String cursorcheck(String N, BufferedReader br) throws IOException { // BufferedReader 매개변수 추가
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int Nlength = N.length();

        // 초기 편집기 상태를 왼쪽 스택에 저장
        for (int i = 0; i < Nlength; i++) {
            leftStack.push(N.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("P")) {
                char ch = s[1].charAt(0);
                leftStack.push(ch);
            } else if (s[0].equals("L")) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (s[0].equals("D")) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if (s[0].equals("B")) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else {
                return null; // 예외 처리: 잘못된 입력
            }
        }

        // 왼쪽 스택의 내용을 오른쪽 스택에 옮김
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        // 오른쪽 스택의 내용을 StringBuilder에 담아서 결과 문자열 생성
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        return sb.toString();
    }
}
