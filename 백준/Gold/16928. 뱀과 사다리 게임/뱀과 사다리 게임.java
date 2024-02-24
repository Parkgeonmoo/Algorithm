
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] board = new int[101]; // 보드를 나타내는 배열
    public static int[] dist = new int[101]; // 각 칸까지의 최소 이동 횟수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리의 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        // 사다리 정보 입력
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to; // from 위치에서 to 위치로 이동
        }

        // BFS를 위한 큐
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // 시작 위치인 1을 큐에 넣음
        dist[1] = 0; // 시작 위치까지의 이동 횟수는 0

        // BFS 시작
        while (!q.isEmpty()) {
            int now = q.poll(); // 현재 위치
            // 주사위를 굴려 나올 수 있는 다음 위치를 계산
            for (int dice = 1; dice <= 6; dice++) {
                int next = now + dice; // 다음 위치
                if (next > 100) continue; // 보드를 벗어나는 경우 건너뜀
                // 사다리나 뱀이 있는 경우 다음 위치를 보드의 해당 위치로 이동
                next = board[next] != 0 ? board[next] : next;
                // 다음 위치를 방문하지 않았다면 큐에 넣고 이동 횟수를 업데이트
                if (dist[next] == 0) {
                    q.offer(next);
                    dist[next] = dist[now] + 1;
                }
            }
        }

        // 100번 위치까지의 최소 이동 횟수 출력
        System.out.println(dist[100]);
    }
}

