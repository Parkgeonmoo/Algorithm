import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int idx = 1;

        while (idx <= N) {
            q.add(idx++);
        }

        while (q.size() > 1) {
            q.poll();
            int first = q.poll();
            q.add(first);
        }

        System.out.println(q.poll());



    }
}