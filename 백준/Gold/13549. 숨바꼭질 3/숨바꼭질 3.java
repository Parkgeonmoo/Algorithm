import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[100001];

        bfs(N);



    }
    public static void bfs(int start) {
       Queue<run> q = new LinkedList<>();
       q.offer(new run(start,1));
       map[start] = 1;


       while (!q.isEmpty()) {
           run temp = q.poll();

           if (temp.x + 1 >= 0 && temp.x + 1 < 100001) {
               if (map[temp.x + 1] == 0 || map[temp.x + 1] > temp.count+1) {
                   map[temp.x + 1] = temp.count+1;
                   q.offer(new run(temp.x+1,temp.count+1));
               }
           }
           if (temp.x -  1 >= 0 && temp.x - 1 < 100001) {
               if (map[temp.x - 1] == 0 || map[temp.x - 1] > temp.count+1) {
                   map[temp.x - 1] = temp.count+1;
                   q.offer(new run(temp.x-1,temp.count+1));
               }
           }
           if (temp.x*2 >= 0 && temp.x*2 < 100001) {
               if (map[temp.x * 2] == 0 || map[temp.x * 2] > temp.count) {
                   map[temp.x * 2] = temp.count;
                   q.offer(new run(temp.x*2,temp.count));
               }
           }
       }
       System.out.println(map[K]-1);

    }
}
class run{
    int x;
    int count;

    public run(int x,int count) {
        this.x = x;
        this.count = count;
    }
}