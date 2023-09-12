import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] king, stone;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        king = StringToPosition(st.nextToken());
        stone = StringToPosition(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            int pos = -1;
            switch(command) {
                case "B" :  pos = 0;
                     break;
                case "RB" : pos = 1;
                     break;
                case "R" : pos = 2;
                    break;
                case "RT" : pos = 3;
                    break;
                case "T" : pos = 4;
                    break;
                case "LT" : pos = 5;
                    break;
                case "L" : pos = 6;
                    break;
                case "LB" : pos = 7;
                    break;
            }


            int[] nKing = new int[] { king[0] + dy[pos], king[1] + dx[pos] };

            if (nKing[0] < 0 || nKing[1] < 0 || nKing[0] >= 8 || nKing[1] >= 8) {
                continue;
            }

            if (nKing[0] == stone[0] && nKing[1] == stone[1]) {
                int[] nStone = new int[] { stone[0] + dy[pos], stone[1] + dx[pos] };
                if (nStone[0] < 0 || nStone[1] < 0 || nStone[0] >= 8 || nStone[1] >= 8) {
                    continue;
                }
                stone[0] = nStone[0];
                stone[1] = nStone[1];
            }

            king[0] = nKing[0];
            king[1] = nKing[1];
        }

        System.out.println(positionToString(king));
        System.out.println(positionToString(stone));
    }

    private static String positionToString(int[] arr) {
        char y = (char) (arr[0] + 'A');
        char x = (char) (arr[1] + '1');
        char[] c = new char[] { y, x };
        return new String(c);
    }

    private static int[] StringToPosition(String str) {
        int y = str.charAt(0) - 'A';
        int x = str.charAt(1) - '1';
        return new int[] { y, x };
    }
}
