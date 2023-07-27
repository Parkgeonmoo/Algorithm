import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main{



    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String inputValue = in.nextLine();

        boolean flag = true; // 변경한 부분
        int mul = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < inputValue.length(); i++){
            switch(inputValue.charAt(i)){
                case '(':
                    stack.push('(');
                    mul *= 2;
                    break;
                case '[':
                    stack.push('[');
                    mul *= 3;
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek()!='('){
                        flag = false;
                        break;
                    }
                    if(inputValue.charAt(i-1)=='(') result += mul;
                    stack.pop();
                    mul /= 2;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek()!='['){
                        flag = false;
                        break;
                    }
                    if(inputValue.charAt(i-1)=='[') result += mul;
                    stack.pop();
                    mul /= 3;
                    break;

                default:
                    flag = false;
                    break;
            }
        }

        if(!flag || !stack.isEmpty()){ // 변경한 부분
           System.out.println(0);
        }else{
            System.out.println(result);
        }


    }
}
