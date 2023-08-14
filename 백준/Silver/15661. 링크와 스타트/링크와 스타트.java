import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int N ;
    static int[][] map;
    static int Min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       N = Integer.parseInt(br.readLine());
       map = new int[N][N];
       visited = new boolean[N];

       for (int i = 0; i < N; i++) {
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < N; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       for (int i = 0; i < N; i++) {
           find(0,0,i);
       }
       System.out.println(Min);



    }
    public static void find(int index,int count,int check) {
        if (check == count) {
            diff();
            return;
        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                find(i+1,count+1,check);
                visited[i] = false;
            }
        }


        }
    public static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (visited[i] == true && visited[j] == true) {
                    start += map[i][j];
                    start += map[j][i];
                }
                else if (visited[i] == false && visited[j] == false){
                    link += map[i][j];
                    link += map[j][i];
                }
            }

        }
        int result = Math.abs(start-link);
        if (result == 0) {
            System.out.println(result);
            System.exit(0);
        }
        Min = Math.min(result,Min);
    }



}