import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        map = new int[26][2];
        for (int i = 0; i< n; i++) {
            String[]temp = in.nextLine().split(" ");
            int node = temp[0].charAt(0)-'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);
            if (left == '.'){
                map[node][0] = -1;
            }else{
                map[node][0] = left - 'A';
            }
            if (right == '.') {
                map[node][1] = -1;
            }else{
                map[node][1] = right-'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    public static void preOrder(int now){
        if (now == -1)
            return;
        System.out.print((char)(now+'A'));
        preOrder(map[now][0]);
        preOrder(map[now][1]);
    }
    public static void inOrder(int now){
        if (now == -1)
            return;
        inOrder(map[now][0]);
        System.out.print((char)(now+'A'));
        inOrder(map[now][1]);

    }
    public static void postOrder(int now){
        if (now == -1)
            return;
        postOrder(map[now][0]);
        postOrder(map[now][1]);
        System.out.print((char)(now+'A'));
    }
}