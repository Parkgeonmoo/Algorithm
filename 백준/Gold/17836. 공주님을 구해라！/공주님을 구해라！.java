import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int N, M, T;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0,0);


    }
    public static void bfs(int startx,int starty) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startx,starty,0,false));
        visited[startx][starty][0] = true;

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if(temp.count > T) {
                System.out.println("Fail");
                return;
            }

            if(temp.x == N - 1 && temp.y == M - 1) {
                System.out.println(temp.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(!temp.gram) {
                        if (!visited[nx][ny][0] && map[nx][ny] == 0) {
                            q.offer(new Node(nx,ny,temp.count+1,temp.gram));
                            visited[nx][ny][0] = true;
                        }
                        else if (!visited[nx][ny][0] && map[nx][ny] == 2) {
                            q.offer(new Node(nx,ny,temp.count+1,true));
                            visited[nx][ny][0] = true;
                        }
                    }
                    else {
                        if (!visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            q.offer(new Node(nx, ny, temp.count + 1, temp.gram));
                        }
                    }


                }
            }

        }
        System.out.println("Fail");
        return;


    }
}


class Node{
    int x;
    int y;
    int count;
    boolean gram;

    Node(int x,int y,int count,boolean gram) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.gram = gram;
    }
}