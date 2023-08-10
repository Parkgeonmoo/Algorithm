import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[] visit;

    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            find(0, 0, i);
        }

        System.out.println(Min);

    }

    static void find(int index, int count, int teamSize) {
        if (count == teamSize) {
            diff();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                find(i + 1, count + 1, teamSize);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                } else if (!visit[i] && !visit[j]) {
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }

        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        Min = Math.min(val, Min);
    }
}
