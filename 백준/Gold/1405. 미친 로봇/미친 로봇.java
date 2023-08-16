import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = {0, 0, 1, -1}; // 동, 서, 남, 북
    static int[] dy = {1, -1, 0, 0};
    static double[] probabilities = new double[4];
    static boolean[][] visited = new boolean[30][30]; // 로봇의 이동 범위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            probabilities[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited[15][15] = true; // 시작 위치를 방문 표시
        double answer = dfs(15, 15, 0);

        System.out.println(answer);
    }

    // (x, y) 위치에서 depth만큼 움직여서 원점에 도달할 확률을 계산
    public static double dfs(int x, int y, int depth) {
        if (depth == N) {
            return 1.0;
        }

        double result = 0.0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                result += dfs(nx, ny, depth + 1) * probabilities[i];
                visited[nx][ny] = false; // 백트래킹
            }
        }

        return result;
    }
}
