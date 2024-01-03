
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        coordinate[] ans = new coordinate[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ans[i] = new coordinate(x, y);
        }
        Arrays.sort(ans);

        for (coordinate temp : ans) {
            System.out.println(temp.x + " " + temp.y);
        }
    }

    static class coordinate implements Comparable<coordinate> {
        int x;
        int y;

        public coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(coordinate other) {
            if (this.x == other.x) {
                return Integer.compare(this.y, other.y);
            } else {
                return Integer.compare(this.x, other.x);
            }
        }
    }
}
