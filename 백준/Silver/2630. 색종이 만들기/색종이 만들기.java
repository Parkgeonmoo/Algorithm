
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int blueCount = 0;
    public static int whiteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        conquer(0, 0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    public static void conquer(int x, int y, int size) {
        int color = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color) {
                    int newSize = size / 2;
                    conquer(x, y, newSize);
                    conquer(x + newSize, y, newSize);
                    conquer(x, y + newSize, newSize);
                    conquer(x + newSize, y + newSize, newSize);
                    return;
                }
            }
        }

        if (color == 1) {
            blueCount++;
        } else {
            whiteCount++;
        }
    }
}

