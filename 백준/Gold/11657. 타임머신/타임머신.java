import java.util.*;
import java.io.*;

public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Edge[] map;
    public static long[] result;
    public static void main(String[]args)throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new Edge[M+1];
        result = new long[N+1];

        Arrays.fill(result,Integer.MAX_VALUE);


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            map[i] = new Edge(s,e,t);
        }

        result[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j  = 0; j < M; j++) {
                Edge edge = map[j];

                if (result[edge.start] != Integer.MAX_VALUE && result[edge.end] >result[edge.start] +edge.weight) {
                    result[edge.end] = result[edge.start] + edge.weight;
                }
            }
        }
        boolean mCycle = false;

        for (int i = 0; i < M; i++) {
            Edge edge = map[i];
            if (result[edge.start] != Integer.MAX_VALUE && result[edge.end] > result[edge.start] +edge.weight) {
                mCycle = true;
            }

        }
        if (!mCycle){
            for (int i = 2; i <= N; i++) {
                if (result[i] == Integer.MAX_VALUE)
                    System.out.println("-1");
                else
                    System.out.println(result[i]);
            }
        }
        else {
            System.out.println("-1");
        }



    }
}
class Edge {
    int start;
    int end;
    int weight;
    public Edge(int start,int end,int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

}