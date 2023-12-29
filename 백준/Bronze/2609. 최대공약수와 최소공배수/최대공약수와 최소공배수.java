
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int ans = uclid(first,second);
        int ans2 = (first * second) / ans;

        System.out.println(ans);
        System.out.println(ans2);




    }
    public static int uclid(int first,int second) {
        if (second == 0) {
            return first;
        }

        return uclid(second,first % second);

    }
}
