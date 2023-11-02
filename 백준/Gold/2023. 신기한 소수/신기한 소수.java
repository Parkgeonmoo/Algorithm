
import java.io.*;

public class Main {
    
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);


    }

    public static void DFS(int total, int length) {
         if (length == N) {
             if (is_prime(total)) {
                 System.out.println(total);
             }
             return;
         }

         for (int i = 1; i < 10; i++) {
             if (i % 2 == 0) {
                 continue;
             }
             if (is_prime(total*10 + i)) {
                 DFS(total * 10 + i, length + 1);
             }
         }
    }

    public static boolean is_prime(int total) {

        for (int i = 2; i <= total / 2; i++) {
            if (total % i == 0) {
                return false;
            }
        }
        return true;
    }
}
