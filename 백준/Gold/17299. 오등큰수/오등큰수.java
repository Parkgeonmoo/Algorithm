import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[]args)throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node [] arr = new Node[N];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] tempString = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = new Node(Integer.parseInt(tempString[i]), 0, 0);
        }

        int[] frequency = new int[1000001];
        for (int i = 0; i < N; i++) {
            frequency[arr[i].value]++;
        }

        stack.push(0);

        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && frequency[arr[stack.peek()].value] < frequency[arr[i].value]) {
                arr[stack.pop()].countcheck = arr[i].value;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()].countcheck = -1;
        }

        for (Node node : arr) {
            sb.append(node.countcheck).append(" ");
        }

        System.out.println(sb.toString());
    }
}

class Node{
    int value;
    int count;
    int countcheck;

    Node(int value, int count, int countcheck) {
        this.value = value;
        this.count = count;
        this.countcheck = countcheck;
    }
}
