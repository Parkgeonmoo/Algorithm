import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static void quickSort(int[] arr, int L, int R){
        //파티션 나누고 오른쪽 값 첫번째 값을 받아옴
        int part2 = partition(arr, L, R);

        //왼쪽 파티션의 요소가 하나 이상
        if (L < part2 - 1)
            quickSort(arr, L, part2 - 1);
        //오른쪽 파티션의 요소가 하나 이상
        if (part2 < R)
            quickSort(arr, part2, R);
    }

    private static int partition(int[] arr, int L, int R){
        int pivot = arr[(L + R)/2];
        while (L <= R) {
            while (arr[L] < pivot) L ++;
            while (arr[R] > pivot) R--;
            if (L <= R) {
                swap (arr, L, R);
                L++;
                R--;
            }
        }
        return L;
    }

    private static void swap(int[] arr, int L, int R){
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        quickSort(A, 0, A.length - 1);

        System.out.println(A[K-1]);
    }
}
