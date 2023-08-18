import java.util.Scanner;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // +, -, *, /
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operators[i] = scanner.nextInt();
        }
        scanner.close();

        dfs(1, numbers[0]);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void dfs(int idx, int result) {
        if (idx == N) {
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                int nextResult = calculate(result, numbers[idx], i);
                dfs(idx + 1, nextResult);
                operators[i]++;
            }
        }
    }

    static int calculate(int a, int b, int operatorIdx) {
        if (operatorIdx == 0) return a + b;
        if (operatorIdx == 1) return a - b;
        if (operatorIdx == 2) return a * b;
        if (operatorIdx == 3) return a / b;
        return 0;
    }
}
