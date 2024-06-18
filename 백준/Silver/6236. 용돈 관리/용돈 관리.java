
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] money;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        money = new int[N];
        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
            start = Math.max(money[i], start); // 최소값은 가장 큰 금액이어야 합니다.
            end += money[i]; // 최대값은 모든 금액의 합이어야 합니다.
        }

        int result = end; // 초기값을 end로 설정합니다.

        while (start <= end) {
            int mid = (start + end) / 2;
            int nowMoney = mid;
            int count = 1; // 첫 인출을 고려합니다.

            for (int i = 0; i < N; i++) {
                if (nowMoney < money[i]) {
                    nowMoney = mid;
                    count++;
                }
                nowMoney -= money[i];
            }

            if (count > M) {
                start = mid + 1;
            } else {
                result = mid; // 가능한 최솟값을 갱신합니다.
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
