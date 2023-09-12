import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0 ,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i<N; i++) {
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        while(true){
            if(map[x][y]==0){ //청소하지 않았다면
                map[x][y]=2; //청소완료
                cnt++;
            }

            boolean flag=false;
            for(int i=0;i<4;i++){
                d=(d+3)%4; //방향전환(왼쪽)

                int nx=x+dx[d];
                int ny=y+dy[d];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(map[nx][ny]==0){ //청소하지 않았다면 이동
                        x=nx;
                        y=ny;
                        flag=true;
                        break;
                    }
                }
            }

            if(!flag){ //네 방향 모두 갈 수 없는 경우
                int nx=x-dx[d];
                int ny=y-dy[d];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(map[nx][ny]!=1){ //벽이 아니라면 후진 가능
                        x=nx;
                        y=ny;
                    }else{ //벽인 경우 작동 중지
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
