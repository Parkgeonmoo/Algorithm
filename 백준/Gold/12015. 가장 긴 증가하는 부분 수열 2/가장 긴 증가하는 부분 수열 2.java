import java.util.Scanner;

public class Main{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] map = new int[N];
        int[] check = new int[N];

        for (int i = 0; i < N; i++) {
            map[i] = in.nextInt();
        }

        check[0] = map[0];
        int checknum = 1;

        for (int i = 1; i < N; i++) {
            int key = map[i];

            if (check[checknum-1] < key){
                checknum++;
                check[checknum-1] = key;
            }
            else{
                int lo = 0;
                int hi = checknum;

                while (lo < hi) {
                    int mid = (lo+hi)/2;

                    if (check[mid] < key) {
                        lo = mid +1;
                    }
                    else{
                        hi = mid ;
                    }
                }
                check[lo] = key;
            }
        }
        System.out.println(checknum);

    }
}