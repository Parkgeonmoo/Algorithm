import java.util.Scanner;

public class Main{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        String N = in.nextLine();
        int[] A = new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            A[i] = Integer.parseInt(N.substring(i,i+1));
        }

        for (int i = 0; i < N.length(); i++) {
            int max = i;
            for (int j = i+1; j <N.length(); j++) {
                if (A[j] > A[max]) {
                    max = j;
                }
                if (A[i] < A[max]) {
                    int temp = A[i];
                    A[i] = A[max];
                    A[max] = temp;
                }
            }

        }
        for (int i = 0; i <N.length();i++) {
            System.out.print(A[i]);
        }
    }
}