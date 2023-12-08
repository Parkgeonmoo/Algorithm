
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] D = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        if (isPenmeration(D)) {
            for (int i = 0; i < N; i++) {
                System.out.print(D[i] + " ");
            }
        }
        else {
            System.out.println(-1);
        }

    }
    public static boolean isPenmeration(int[] D) {
        int iLength = D.length - 1;

        while (iLength > 0 && D[iLength - 1] <= D[iLength]) {
            iLength--;
        }
        if (iLength <= 0) {
            return false;
        }

        int jLength = D.length - 1;

        while (D[iLength - 1] <= D[jLength]) {
            jLength--;
        }

        swap (D,iLength - 1,jLength);


        jLength = D.length - 1;

        while (iLength < jLength) {
            swap(D,iLength,jLength);
            iLength++;
            jLength--;
        }


        return true;

    }

    public static void swap(int[] D,int iLength,int jLength) {
        int temp = D[iLength];
        D[iLength] = D[jLength];
        D[jLength] = temp;
    }
}

