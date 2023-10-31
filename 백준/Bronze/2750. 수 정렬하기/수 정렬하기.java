import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 0; i < N -1 ; i++) {
            for (int j = 0; j < N - i -1; j++) {
                if (ans[j+1] < ans[j]) {
                    int temp = ans[j+1];
                    ans[j+1] = ans[j];
                    ans[j] = temp;
                }
            }
        }

        for (int i : ans) {
            System.out.println(i);
        }




    }
}