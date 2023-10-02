import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] map = new int[n+1];
        int[] check = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        check[1] = map[1];

        int longnum  = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1 || map[i] > check[longnum-1]) {
                check[longnum++] = map[i];
            }
            else{
                int start = 0;
                int end = longnum;
                int idx = longnum;

                while (start < end) {
                    int mid = (start+end) / 2;
                    if (check[mid] >= map[i]) {
                        idx = Math.min(idx,mid);
                        end = mid;
                    }else{
                        start = mid+1;
                    }
                }
                check[idx] = map[i];
            }
        }
        System.out.println(longnum);



    }
}