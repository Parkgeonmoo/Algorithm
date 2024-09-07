import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]> position = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            position.add(new int[]{start, end});
        }

        position.sort(Comparator.comparingInt(a -> a[0]));

        int result = 0;
        int currentStart = position.get(0)[0];
        int currentEnd = position.get(0)[1];

        for (int i = 1; i < position.size(); i++) {
            int[] line = position.get(i);
            int start = line[0];
            int end = line[1];

            if (start <= currentEnd) {
                currentEnd = Math.max(currentEnd, end);
            } else {
                result += currentEnd - currentStart;
                currentStart = start;
                currentEnd = end;
            }
        }

        result += currentEnd - currentStart;

        System.out.println(result);
    }
}
