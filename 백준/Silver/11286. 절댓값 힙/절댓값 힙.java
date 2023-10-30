import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            else {
                return first_abs - second_abs;
            }
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now != 0) {
                pq.add(now);
            }

            else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()+"\n");
                }
                else{
                    sb.append(0+"\n");
                }
            }
        }

        System.out.println(sb.toString());




    }
}
