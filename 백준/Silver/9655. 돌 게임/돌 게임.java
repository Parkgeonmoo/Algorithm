
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] D = new int[N+1];
        StringBuilder sb = new StringBuilder();

        D[0] = N;
        

        for (int i = 1; i <= N; i++) {

            D[i] = D[i-1];

            if (D[i] >= 3) {
                D[i] = D[i] - 3;
                if (D[i] == 0 ) {
                    if (i % 2 != 0) {
                        sb.append("SK");
                        break;
                    }
                    else {
                        if (i % 2 == 0) {
                            sb.append("CY");
                            break;
                        }
                    }
                }
            }
            else {
                D[i] = D[i] - 1;
                if (D[i] == 0 ) {
                    if (i % 2 != 0) {
                        sb.append("SK");
                        break;
                    }
                    else {
                        if (i % 2 == 0) {
                            sb.append("CY");
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());











    }
}

