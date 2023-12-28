
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[][] people;
        int count = 0;


        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            people = new int[N][2];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                people[j][0] = Integer.parseInt(st.nextToken());
                people[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(people,new Comparator<int[]>() {
                public int compare(int[] s1,int[] s2) {
                    return Integer.compare(s1[0],s2[0]);
                }
            });

            int top = people[0][1];
            count = 0;

            for (int j = 1; j < N; j++) {
                if (top < people[j][1]) {
                    count++;
                    continue;
                }
                top = people[j][1];
            }
            System.out.println(N - count);
        }



    }
}
