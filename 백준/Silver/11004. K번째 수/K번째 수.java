
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        quick_sort(num,0,N-1);

        System.out.println(num[K-1]);

    }

    public static void quick_sort(int[] arr, int start,int end) {
        if (end - start < 1) {
            return;
        }

        int pivot = (start + end) / 2;
        int pivotValue = num[pivot];
        int s = start;
        int e = end;

        while (s <= e) {
            while (num[s] < pivotValue) {
                s++;
            }

            while (num[e] > pivotValue) {
                e--;
            }

            if (s <= e) {
                swap(arr,s,e);
                s++;
                e--;
            }
        }

        quick_sort(arr,start,e);
        quick_sort(arr,s,end);

    }

    public static void swap(int[] arr,int start,int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}