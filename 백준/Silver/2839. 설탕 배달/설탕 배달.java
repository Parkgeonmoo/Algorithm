
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 3) { // N이 3보다 작은 경우를 처리
            System.out.println(-1);
            return;
        }
        
        int[] D = new int[N + 1]; // 배열의 크기를 N+1로 설정

        Arrays.fill(D, 5001); // 최대값으로 초기화

        D[3] = 1;
        if (N >= 5) { // N이 5 이상인 경우에만 D[5] 값을 설정
            D[5] = 1;
        }

        for (int i = 6; i <= N; i++) {
            if (D[i - 3] != 5001) { // D[i-3]이 가능한 경우만 계산
                D[i] = D[i - 3] + 1;
            }
            if (D[i - 5] != 5001) { // D[i-5]가 가능한 경우만 계산
                D[i] = Math.min(D[i], D[i - 5] + 1);
            }
        }

        if (D[N] == 5001) {
            System.out.println(-1);
        } else {
            System.out.println(D[N]);
        }
    }
}
