
import java.io.*;
import java.util.*;
public class Main {
    static long[] tree;
    static boolean maxleft = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int count = 0;
        long length = N;

        while (length != 0) {

            if (length > 1 && length % 2 == 1) {
                maxleft = false;
            }
            length /= 2;
            count++;
        }

        if (maxleft == true) {
            count--;
        }

        int treeSize = (int)Math.pow(2,count+1);
        int leafNode = treeSize / 2 - 1;
        tree = new long[treeSize + 1];

        Arrays.fill(tree,Integer.MAX_VALUE);

        for (int i = leafNode + 1; i <= leafNode + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);
        

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            a = leafNode + a;
            b = leafNode + b;
            long result = findMin((int)a,(int)b);
            System.out.println(result);
        }




    }

    public static long findMin(int start,int end) {
        long partMin = Integer.MAX_VALUE;

        while (start <= end) {
            if (start % 2 == 1) {
                partMin = Math.min(partMin,tree[start]);
                start++;
            }
            if (end % 2 == 0) {
                partMin = Math.min(partMin,tree[end]);
                end--;
            }

            start /= 2;
            end /= 2;
        }
        return partMin;

    }

    public static void setTree(int num) {
        while (num != 1) {
            if (tree[num/2] > tree[num]) {
                tree[num/2] = tree[num];
            }
            num--;

        }
    }

}