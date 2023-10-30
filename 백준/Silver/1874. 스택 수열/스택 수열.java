import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[]args){
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] A = new int[N];
        for (int i =0; i < A.length; i++){
            A[i] = in.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        for(int i = 0; i < A.length; i++){
            int su = A[i];
            if (su >= num){
            while(su >= num){
                stack.push(num++);
                bf.append("+\n");
            }
            stack.pop();
            bf.append("-\n");
        }
        else{
            int n = stack.pop();
            if(n > su){
                System.out.println("NO");
                result = false;
                break;
            }
              else{
                bf.append("-\n");
            }
        }
        
    }
    if(result) System.out.println(bf.toString());
}
}