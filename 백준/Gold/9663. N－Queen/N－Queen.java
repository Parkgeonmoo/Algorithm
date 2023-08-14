import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] result;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 변수 N 초기화 수정

        result = new int[N];
        find(0);
        System.out.println(answer);
    }

    public static void find(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) { // col 변수 수정
            if (isValid(row, col)) {
                result[row] = col;
                find(row + 1);
            }
        }
    }

    public static boolean isValid(int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            if (result[prevRow] == col || Math.abs(result[prevRow] - col) == Math.abs(prevRow - row)) {
                return false;
            }
        }
        return true;
    }
}
