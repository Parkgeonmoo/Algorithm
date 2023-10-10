import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main{
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][]timecheck = new int[N][2];

        for (int i  = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            timecheck[i][0] = Integer.parseInt(st.nextToken());
            timecheck[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(timecheck, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] - o2[1] == 0) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int sum = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if(timecheck[i][0] >= end) {
                sum++;
                end = timecheck[i][1];
            }
        }
        System.out.println(sum);
    }
}