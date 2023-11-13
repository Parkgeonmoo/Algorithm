
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] truth;
    public static int[] parent;
    public static ArrayList<Integer>[] people;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        truth = new int[t];
        parent = new int[N+1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < t; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        people = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int listSize = Integer.parseInt(st.nextToken());
            people[i] = new ArrayList<>();

            for (int j = 0; j < listSize; j++) {
                people[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < M; i++) {
            int first = people[i].get(0);

            for (int j = 1; j < people[i].size(); j++) {
                union(first,people[i].get(j));
            }
        }


        for (int i = 0; i < M; i++) {
            boolean isPossible =  true;
            int cur = people[i].get(0);
            for (int j = 0; j < truth.length; j++) {
                if (find(cur) == find(truth[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) count++;
        }
        System.out.println(count);



    }

    public static void union(int A,int B) {
        A = find(A);
        B = find(B);

        if (A != B) {
            parent[B] = A;
        }
    }

    public static int find(int num) {
        if (parent[num] == num) {
            return num;
        }
        else {
            return parent[num] = find(parent[num]);
        }
    }
}



