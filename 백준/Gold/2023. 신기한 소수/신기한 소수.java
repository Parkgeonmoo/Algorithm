import java.util.*;
import java.io.*;

public class Main{
    public static int N;
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }
    public static void DFS(int num,int jarisu) {
        if (jarisu == N){
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0){
                continue;
            }
            if (isPrime(num*10 + i)) {
                DFS(num*10+i,jarisu+1);
            }
        }
    }
    static boolean isPrime(int num) {
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}