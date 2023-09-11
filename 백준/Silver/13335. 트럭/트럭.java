import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, w, L;
    static int[] trucks;
    static int bridgeindex;
    static int totalweigth = 0;
    static int time = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        trucks = new int[n];
        bridgeindex = 0;


        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int  i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < w; i++) {
            queue.add(0);
        }


        while (bridgeindex < trucks.length) {
               totalweigth -= queue.poll();

               int truckweigth = trucks[bridgeindex];

            if (totalweigth + truckweigth <= L) {
                queue.add(truckweigth);
                totalweigth += trucks[bridgeindex];
                bridgeindex++;
            }else{
                queue.add(0);
            }
            time++;
        }

        while (totalweigth > 0) {
            totalweigth -= queue.poll();
            time++;
        }

        System.out.println(time);







    }
}
