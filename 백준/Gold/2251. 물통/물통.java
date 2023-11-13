
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] Receiver = {0,0,1,1,2,2};
    public static int[] sender = {1,2,0,2,0,1};
    static boolean answer[] = new boolean[201];
    public static int[] now;
    public static boolean[][] visited = new boolean[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        now = new int[3];
        now[0] = A;
        now[1] = B;
        now[2] = C;

        BFS();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }












    }
    public static void BFS() {
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0,0));
        visited[0][0] =true;
        answer[now[2]] = true;

        while (!q.isEmpty()) {
            AB temp = q.poll();
            int A = temp.A;
            int B = temp.B;
            int C = now[2] - A - B;

            for (int i = 0; i < 6; i++) {
                int[] next = {A,B,C};
                next[Receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;

                 if (next[Receiver[i]] > now[Receiver[i]]) {
                     next[sender[i]] = next[Receiver[i]] - now[Receiver[i]];
                     next[Receiver[i]] = now[Receiver[i]];
                 }
                 if (!visited[next[0]][next[1]]) {
                     visited[next[0]][next[1]] = true;
                     q.add(new AB(next[0],next[1]));
                     if (next[0] == 0) {
                         answer[next[2]] = true;
                     }
                 }

            }
        }
    }
    static class AB{
        int A;
        int B;
        public AB(int A,int B){
            this.A = A;
            this.B = B;
        }
    }
}



