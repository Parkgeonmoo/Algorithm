
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(prevPermutation(arr)) {
            for(int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.print("-1");
        }
    }

    public static boolean prevPermutation(int[] arr) {
        int i = arr.length - 1;
        while(i > 0 && arr[i-1] <= arr[i]) {
            i--;
        }

        if(i <= 0) {
            return false; // 이전 순열이 없는 경우
        }

        int j = arr.length - 1;
        while(arr[j] >= arr[i-1]) {
            j--;
        }

        swap(arr, i-1, j);

        j = arr.length - 1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
