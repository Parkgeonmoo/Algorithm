import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];


        dfs(0);

        System.out.println(answer);




    }
    public static void dfs(int row) {
        if (row == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isValid(row, i)) {
                arr[row] = i;
                dfs(row + 1);
            }
        }
    }
    public static boolean isValid(int row,int col) {
        for (int prevrow = 0; prevrow < row; prevrow++) {
            if (arr[prevrow] == col || Math.abs(arr[prevrow] - col) == Math.abs(prevrow - row)) {
                return false;
            }
        }
        return true;
    }
}
