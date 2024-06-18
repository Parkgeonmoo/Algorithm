import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());  // 총 게임 수
        long Y = Long.parseLong(st.nextToken());  // 이긴 게임 수

        long originalZ = (Y * 100) / X;  // 초기 승률
        if (originalZ >= 99) {
            // 승률이 99% 이상이면 승률을 올리는 것이 불가능
            System.out.println(-1);
            return;
        }

        long start = 0;
        long end = X;
        long answer = -1;

        while (start <= end) {
            long mid = (start + end) / 2;
            long newZ = ((Y + mid) * 100) / (X + mid);

            if (newZ > originalZ) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
