
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ACount = Integer.parseInt(st.nextToken());
        int BCount = Integer.parseInt(st.nextToken());
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        int[] checkA = new int[ACount];
        int[] checkB = new int[BCount];
        int count = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < ACount; i++) {
            checkA[i] = Integer.parseInt(st.nextToken());
            A.add(checkA[i]);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < BCount; i++) {
            checkB[i] = Integer.parseInt(st.nextToken());
            B.add(checkB[i]);
        }

        for (int i = 0; i < ACount; i++) {
            if (!(B.contains(checkA[i]))) {
                count++;
            }
        }

        for (int i = 0; i < BCount; i++) {
            if (!(A.contains(checkB[i]))){
                count++;
            }
        }

        System.out.println(count);

    }
}
