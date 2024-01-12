
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        sb.append("IOI");

        if (N == 1) {
            // N이 1인 경우에는 IOI가 이미 추가되어 있으므로 더 이상 할 일이 없습니다.
        } else {
            while (N != 1) {
                sb.append("OI");
                N--;
            }
        }

        String s = br.readLine();

        // 패턴이 몇 번 등장하는지 세는 카운터
        int count = 0;

        // s의 각 위치에서 패턴과 일치 여부 확인
        for (int i = 0; i <= s.length() - sb.toString().length(); i++) {
            if (sb.toString().equals(s.substring(i, i + sb.toString().length()))) {
                // 일치하는 경우 카운터 증가
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
