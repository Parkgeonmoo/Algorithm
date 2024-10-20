import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];
        int[] result = new int[N];

        // 키 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 배열을 채우기
        for (int i = 0; i < N; i++) {
            int count = heights[i]; // 현재 사람의 키에 해당하는 수
            for (int j = 0; j < N; j++) {
                // 빈 자리에서 count를 줄여가며 해당 위치에 사람을 배치
                if (result[j] == 0) { // 빈 자리 찾기
                    if (count == 0) {
                        result[j] = i + 1; // 사람 번호는 1부터 시작
                        break;
                    }
                    count--;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
