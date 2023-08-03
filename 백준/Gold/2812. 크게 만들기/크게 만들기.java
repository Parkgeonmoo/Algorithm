import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[]args)throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int stacksize = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[i] = Character.getNumericValue(c);
        }

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            while (!stack.isEmpty() && stack.peek() < temp && stacksize < K) {
                stack.pop();
                stacksize++;
            }
            stack.push(temp);
        }


        for (int i = 0; i < N-K; i++) {
            System.out.print(stack.elementAt(i));
        }


    }
}
