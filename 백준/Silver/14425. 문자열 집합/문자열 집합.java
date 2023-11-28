
import java.util.*;
import java.io.*;

public class Main {

    public static int V,E;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < V; i++) {
            String temp = br.readLine();
            map.put(temp,i);
        }

        for (int i = 0; i < E; i++) {
            String temp = br.readLine();

            if (map.containsKey(temp)) {
                answer++;
            }
        }

        System.out.println(answer);









    }
}