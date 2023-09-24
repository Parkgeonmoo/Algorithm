import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A[] = new int[N]; //삽입정렬 할 배열
        int S[] = new int[N]; // 배열 합 넣을 배열

        for (int i = 0; i < N; i++){
            A[i] = in.nextInt();
        }
        for(int i = 1; i<N; i++){
            int insert_point = i;
            int insert_value = A[i];
            for(int j = i-1; j >=0 ; j--) {
                if (A[j] < A[i]) {
                    insert_point = j + 1;
                    break;
                }
                if (j == 0) {
                    insert_point = 0;
                }
            }
                for(int j=i; j>insert_point; j--){
                    A[j] = A[j-1];

                }
                A[insert_point] = insert_value;

            }
            S[0] = A[0];
        for(int i = 1; i < N; i++){
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum = sum+S[i];
        }
        System.out.println(sum);

    }
}
