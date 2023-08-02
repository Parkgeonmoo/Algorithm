import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.io.IOException;

public class Main{
	public static void main(String[]args)throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[]A = new int[n];
		int[]ans = new int[n];
		String[]str = bf.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		for(int i = 1; i < n; i++) {
			while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
		        ans[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		while(!stack.empty()) {
			ans[stack.pop()] = -1;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < n; i++) {
			bw.write(ans[i]+ " ");
		}
		
		bw.flush();
		bw.close();
	}
}