import java.sql.Array;
import java.util.*;

public class Main{
    public static int[] truep;
    public static ArrayList<Integer>[] party;
    public static int[] parent;
    public static int result;

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int t = in.nextInt();
        result =0;
        truep = new int[t];

        for (int i = 0; i < t; i++) {
            truep[i] = in.nextInt();
        }

        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<Integer>();
            int party_size = in.nextInt();
            for (int j = 0; j < party_size; j++) {
                party[i].add(in.nextInt());
            }
        }
        parent = new int[N+1];
        for (int i = 0; i<= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int fristpeople = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(fristpeople,party[i].get(j));
            }
        }
        for (int i = 0; i < M; i++) {
            boolean isPossible =  true;
            int cur = party[i].get(0);
            for (int j = 0; j < truep.length; j++) {
                if (find(cur) == find(truep[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) result++;
        }
        System.out.println(result);
    }
    public static void union(int a,int b) {
        a = find(a);
        b = find(b);
        if (a != b){
            parent[b] = a;
        }
    }
    public static int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
    public static boolean checkSame(int a,int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        }
        return false;
        }
    }
