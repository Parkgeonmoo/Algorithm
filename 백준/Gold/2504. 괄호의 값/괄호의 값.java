import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String S=st.nextToken();
		Stack<Character> stack=new Stack<>();
		int K=1;
		int sum=0;
		for(int i=0;i<S.length();i++) {
			if(S.charAt(i)=='(') {
				K*=2;
				stack.add('(');
			}else if(S.charAt(i)=='[') {
				K*=3;
				stack.add('[');
			}else if(!stack.isEmpty()&&S.charAt(i)==')') {
				if(i-1>=0&&S.charAt(i-1)=='(') {
					sum+=K;
				}else {
					if(stack.peek()!='(') {
						sum=0;
						break;
					}
				}
				K/=2;
				stack.pop();
			}else if(!stack.isEmpty()&&S.charAt(i)==']') {
				if(i-1>=0&&S.charAt(i-1)=='[') {
					sum+=K;
				}else {
					if(stack.peek()!='[') {
						sum=0;
						break;
					}
				}
				K/=3;
				stack.pop();
			}else {
				sum=0;
				break;
			}
		}
		if(!stack.isEmpty())
			System.out.println(0);
		else
			System.out.println(sum);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}