import  java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    static int n,m;
    static long max;
    static long[][] map;

    public static void main(String[]args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new long[1001][1001];

        for (int i =0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Long.parseLong(String.valueOf(s.charAt(j)));
                if(map[i][j] == 1 && j > 0 && i > 0) {
                    map[i][j] = Math.min(map[i-1][j-1],Math.min(map[i][j-1],map[i-1][j]))+map[i][j];
                }
                if (max < map[i][j]) {
                    max = map[i][j];

                }
            }
        } // 맵입력


        System.out.println(max*max);
    }

}