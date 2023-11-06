import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String a = br.readLine().trim(); // 첫 번째 이진수
            String b = br.readLine().trim(); // 두 번째 이진수
            int hammingDistance = calculateHammingDistance(a, b);
            System.out.println("Hamming distance is " + hammingDistance + ".");
        }
    }

    // 해밍 거리 계산 함수
    private static int calculateHammingDistance(String a, String b) {
        int hammingDistance = 0;
        int len = a.length();

        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}
