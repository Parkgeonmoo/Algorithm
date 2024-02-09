
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, Integer> clothes;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            clothes = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상의 이름은 필요없으므로 무시
                String type = st.nextToken();
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for (int val : clothes.values()) {
                answer *= (val+1); // 안 입는 경우를 포함하기 위해 1을 더함
            }

            answer -= 1; // 아무것도 안 입는 경우를 뺌
            System.out.println(answer);
        }
    }
}
