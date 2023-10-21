import java.util.*;

public class Main{

    public static int[] parent;
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        parent = new int[N+1];

        for (int i = 0 ; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M ;i++) {
            int question = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if (question == 0) {
                union(a,b);
            }else{
                if (checkSame(a,b)) {
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
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