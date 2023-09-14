import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static String[] line = new String[4];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            line[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            // 각 톱니바퀴의 회전 방향을 저장하는 배열
            int[] directions = new int[4];
            directions[position] = direction;

            // 왼쪽 톱니바퀴들에 대한 처리
            for (int j=position-1; j>=0; j--) {
                if(line[j].charAt(2) != line[j+1].charAt(6)) directions[j]=-directions[j+1];
                else break;
            }

            // 오른쪽 톱니바퀴들에 대한 처리
            for(int j=position+1;j<4;j++){
                if(line[j].charAt(6)!=line[j-1].charAt(2)) directions[j]=-directions[j-1];
                else break;
            }

            // 정해진 방향대로 모든 톱니바퀴를 회전시킵니다.
            for(int j=0;j<4;j++){
                if(directions[j]==0) continue;
                if(directions[j]==1){
                    char temp=line[j].charAt(7);
                    line[j]=temp+line[j].substring(0,7);
                }else{
                    char temp=line[j].charAt(0);
                    line[j]=line[j].substring(1)+temp;
                }
            }
        }

        for(int i=0;i<4;i++){
            ans+=((line[i].charAt(0)-'0')*(int)Math.pow(2,i));
        }

        System.out.println(ans);

    }
}
