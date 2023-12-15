import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[]args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] map = new int[N]; //수열
        int[] Lmap = new int[N]; // 왼쪽 누적합 구하기
        int[] Rmap = new int[N]; // 오른쪽 누적합 구하기
        st = new StringTokenizer((br.readLine()));

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        } // 수열 입력

        Lmap[0] = map[0]; // 첫번쨰 값 동일하게 맞추기
        int result = map[0]; // 최대합 변수

        for (int i = 1; i < N; i++) {
            Lmap[i] = Math.max(map[i],Lmap[i-1]+map[i]);
            result = Math.max(Lmap[i],result);


        }
        Rmap[N-1] = map[N-1];
        for (int i = N-2; i >= 0; i--) {
            Rmap[i] = Math.max(map[i],Rmap[i+1]+map[i]);

        }

        for (int i = 1; i < N-1; i++) {
            int temp = Lmap[i-1]+Rmap[i+1];
            result = Math.max(temp,result);
        }
        System.out.println(result);
    }
}