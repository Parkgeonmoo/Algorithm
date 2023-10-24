import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] map = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < map.length; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        int start_index = 1;
        int end_index = N;
        int count = 0;
        while (start_index < end_index) {
            if ((map[start_index]+map[end_index]) == M) {
                count++;
                start_index++;
                end_index--;
            }else if ((map[start_index]+map[end_index]) > M) {
                end_index--;
            }else{
                start_index++;
            }
        }
        System.out.println(count);


    }
}