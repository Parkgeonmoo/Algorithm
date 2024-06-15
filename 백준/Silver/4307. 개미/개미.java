import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] positions = new int[n];
            for (int i = 0; i < n; i++) {
                positions[i] = Integer.parseInt(br.readLine());
            }

            int minTime = 0;
            int maxTime = 0;

            for (int pos : positions) {
                // 가장 빠른 시간: 현재 위치와 양 끝 중 가까운 쪽으로 이동하는 시간
                int timeToEdge = Math.min(pos, l - pos);
                minTime = Math.max(minTime, timeToEdge);

                // 가장 느린 시간: 현재 위치와 양 끝 중 먼 쪽으로 이동하는 시간
                int timeToFarEdge = Math.max(pos, l - pos);
                maxTime = Math.max(maxTime, timeToFarEdge);
            }

            sb.append(minTime).append(" ").append(maxTime).append("\n");
        }

        System.out.print(sb.toString());
    }
}

