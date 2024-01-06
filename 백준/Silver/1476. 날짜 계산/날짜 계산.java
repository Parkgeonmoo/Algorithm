
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static long E, S, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         E = Integer.parseInt(st.nextToken());
         S = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         int answer = 0;

        for (int i = 1; i <= 7980; i++) {
            if ((i % 15 == 0 ? 15 : i % 15) == E &&
                    (i % 28 == 0 ? 28 : i % 28) == S &&
                    (i % 19 == 0 ? 19 : i % 19) == M) {
                answer = i;
                break;
            }
        }


        System.out.println(answer);





    }

}

