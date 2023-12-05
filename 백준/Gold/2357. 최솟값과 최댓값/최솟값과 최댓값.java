
import java.io.*;
import java.util.*;

public class Main {
    static long[] minTree;
    static long[] maxTree;
    static boolean check = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int count = 0;
        long length = N;

        while (length != 0) {
            if (length > 1 && length % 2 == 1) {
                check = false;
            }
            length /= 2;
            count++;
        }

        if (check == true) {
            count--;
        }

        int treeSize = (int) Math.pow(2, count + 1);
        int leafNode = treeSize / 2 - 1;
        minTree = new long[treeSize + 1];
        maxTree = new long[treeSize + 1];

        Arrays.fill(minTree, Long.MAX_VALUE);
        Arrays.fill(maxTree, Long.MIN_VALUE);

        for (int i = leafNode + 1; i <= leafNode + N; i++) {
            long temp = Long.parseLong(br.readLine());
            minTree[i] = temp;
            maxTree[i] = temp;
        }

        setMinTree(treeSize - 1);
        setMaxTree(treeSize - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long minResult = getMinVal(leafNode + a, leafNode + b);
            long maxResult = getMaxVal(leafNode + a, leafNode + b);
            System.out.println(minResult + " " + maxResult);
        }
    }

    public static long getMinVal(long start, long end) {
        long partMinNum = Long.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                partMinNum = Math.min(partMinNum, minTree[(int) start]);
                start++;
            }
            if (end % 2 == 0) {
                partMinNum = Math.min(partMinNum, minTree[(int) end]);
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return partMinNum;
    }

    public static long getMaxVal(long start, long end) {
        long partMaxNum = Long.MIN_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                partMaxNum = Math.max(partMaxNum, maxTree[(int) start]);
                start++;
            }
            if (end % 2 == 0) {
                partMaxNum = Math.max(partMaxNum, maxTree[(int) end]);
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return partMaxNum;
    }

    public static void setMinTree(int num) {
        while (num != 1) {
            if (minTree[num / 2] > minTree[num]) {
                minTree[num / 2] = minTree[num];
            }
            num--;
        }
    }

    public static void setMaxTree(int num) {
        while (num != 1) {
            if (maxTree[num / 2] < maxTree[num]) {
                maxTree[num / 2] = maxTree[num];
            }
            num--;
        }
    }
}
