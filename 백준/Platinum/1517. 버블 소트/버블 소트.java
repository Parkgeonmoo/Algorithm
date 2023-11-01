import java.io.*;
import java.util.*;

public class Main{
    public static int[] map;
    public static int[] tmp;
    public static long result;
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        map = new int[N+1];
        tmp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        merge_sort(1,N);
       System.out.println(result);

    }
    public static void merge_sort(int S,int E) {
        if (E-S < 1) {
            return;
        }
        int mid = (S + E) / 2;
        merge_sort(S,mid);
        merge_sort(mid+1,E);

        for (int i = S; i <= E; i++) {
            tmp[i] = map[i];
        }
        int k = S;
        int index1 = S;
        int index2 = mid+1;
        while (index1 <= mid && index2 <= E) {
             if (tmp[index1] > tmp[index2]) {
                 map[k] = tmp[index2];
                 result = result + index2 - k;
                 index2++;
                 k++;
             }else {
                 map[k] = tmp[index1];
                 index1++;
                 k++;
             }
        }
        while (index1 <= mid) {
            map[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= E) {
            map[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}