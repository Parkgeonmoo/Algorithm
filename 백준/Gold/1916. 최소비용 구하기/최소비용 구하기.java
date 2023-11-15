
import java.util.*;
import java.io.*;

public class Main {
    public static int[] result;
    public static boolean[] visited;
    public static ArrayList<Bus>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        result = new int[N+1];
        visited = new boolean[N+1];
        map = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<Bus>();
        }

        for (int i = 0; i <= N; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            map[s].add(new Bus(e,t));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(start,end) + "\n");
        bw.close();




    }
    public static int dijkstra(int start,int end) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        result[start] = 0;
        pq.add(new Bus(start,0));


        while (!pq.isEmpty()) {
            Bus temp = pq.poll();
            int targetCity = temp.endCity;

            if (visited[targetCity]) continue; 
            visited[targetCity] = true;
            
            for (Bus check : map[targetCity]) {
                if (!visited[check.endCity] && result[check.endCity] > result[targetCity] + check.time) {
                    result[check.endCity] = result[targetCity] + check.time;
                    pq.add(new Bus(check.endCity,result[check.endCity]));
                }
            }
        }

        return result[end];
    }
}


class Bus implements Comparable<Bus> {
    int endCity;
    int time;

    public Bus(int endCity,int time) {
        this.endCity = endCity;
        this.time = time;
    }


    @Override
    public int compareTo(Bus o) {
        return this.time - o.time;
    }
}