import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int [] a = new int [3];
		for(int i =0; i < 3; i++) {
			a[i] = scan.nextInt();
		}
		
		
		int [] c = new int [3];
		for(int i =0; i < 3; i++) {
			c[i] = scan.nextInt();
		}
	
		int bx = c[0] - a[2];
		int bz = c[1]  / a[1];
		int by = c[2] - a[0];
		//방정식 형태로 풀어서 출력하면된다.
		
		System.out.print(bx+ " " + bz+ " " + by);
		
	}
 
    }
