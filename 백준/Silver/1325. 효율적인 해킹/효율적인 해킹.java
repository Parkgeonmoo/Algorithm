import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Main{
    public static boolean[] check;
    public static ArrayList<Integer>[] map;
    public static int[] answer;
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        map = new ArrayList[N+1];
        answer = new int[N+1];

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            map[A].add(B);
        }


        for (int i =1 ; i <= N; i++) {
            check = new boolean[N+1];
            BFS(i);
        }

        int maxVal = 0;

        for (int i = 1; i <= N; i++) {
            maxVal = Math.max(maxVal,answer[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (answer[i] == maxVal)
                System.out.print(i+ " ");
        }
    }

    public static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        check[Node] = true;
        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            for (int i : map[now_Node]) {
                if (check[i] == false) {
                    check[i] = true;
                    answer[i] ++;
                    queue.add(i);

                }
            }
        }


    }
}