import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static int[][] virus;
    static int N,M;
    static int result = 0;
    public static void main(String[]args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        virus = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        } // 맵입력
        dfs(0);
        System.out.println(result);



    }
    public static void dfs(int depth){
        if (depth == 3) {
           bfs();
           return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        } // 벽을 모든 경우의 수로 세워본다 bfs 호출로 세워본 후 해당 부분이 괜찮은 솔루션인지 알 수 있음



    }
    public static void bfs() {
        Queue<DTO> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus[i][j] = map[i][j];
            }
        } // 맵을 그대로 복사

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(virus[i][j] == 2) {
                    queue.add(new DTO(i,j));
                }
            }
        }//맵 중에 바이러스가 있는 곳을 queue에 넣어둠

        while(!queue.isEmpty()) {
            DTO next = queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = next.x + dx[i];
                int cy = next.y + dy[i];

                if(cx >= 0 && cy >= 0 && cx < N && cy <M) {
                    if(virus[cx][cy] == 0) {
                        virus[cx][cy] = 2;
                        queue.add(new DTO(cx,cy));
                    }
                }
            }
        }
        count(virus);
    }
    public static void count(int [][] virus) {
        int temp = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(virus[i][j] == 0) {
                    temp++;
                }
            }

        }
        result = Math.max(result,temp);
    } // 바이러스 퍼지면서 남은 칸 수를 계산하는 곳

        }

        class DTO{
    int x;
    int y;

    DTO(int x,int y) {
        this.x = x;
        this.y = y;

            }

        }