import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int heigth = Integer.parseInt(st.nextToken());
          
            else{
                while(true) {
                    if (stack.isEmpty()) {
                        sb.append("0" + " ");
                        stack.push(new Top(heigth,i));
                        break;
                    }
                    else{
                        Top top = stack.peek();
                        if (top.height > heigth) {
                            stack.push(new Top(heigth,i));
                            sb.append(top.index+ " ");
                            break;
                        }
                        else{
                            stack.pop();
                        }
                    }
                }
            }

        }
        System.out.println(sb.toString());
    }
}
class Top{
    int height;
    int index;

    Top(int height,int index) {
        this.height = height;
        this.index = index;
    }
}
