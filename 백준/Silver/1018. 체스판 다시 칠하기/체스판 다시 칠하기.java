
import java.io.*;
import java.util.*;

public class Main {
    public static char[][] board;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int minChanges = Integer.MAX_VALUE;

        for (int i = 0; i + 7 < N; i++) {
            for (int j = 0; j + 7 < M; j++) {
                minChanges = Math.min(minChanges, findMinChanges(i, j));
            }
        }

        System.out.println(minChanges);
    }

    public static int findMinChanges(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int changesB = 0;
        int changesW = 0;

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'B') changesB++;
                    if (board[i][j] != 'W') changesW++;
                } else {
                    if (board[i][j] != 'W') changesB++;
                    if (board[i][j] != 'B') changesW++;
                }
            }
        }

        return Math.min(changesB, changesW);
    }
}
