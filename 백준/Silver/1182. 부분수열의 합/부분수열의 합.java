import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) { // 부분 집합 크기 1부터 N까지 순차적으로 탐색
            find(0, 0, i);
        }

        System.out.println(answer);
    }

    public static void find(int index, int currentSum, int size) {
        if (size == 0) {
            if (currentSum == S) {
                answer++;
            }
            return;
        }
        if (index >= N) {
            return;
        }

        // 현재 원소 선택
        find(index + 1, currentSum + arr[index], size - 1);

        // 현재 원소 선택하지 않음
        find(index + 1, currentSum, size);
    }
}
