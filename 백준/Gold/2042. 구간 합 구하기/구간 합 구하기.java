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
        long K = Long.parseLong(st.nextToken());

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
        tree = new long[treeSize+1];

        for (int i = leafNode + 1 ; i <= leafNode + N; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i] = Long.parseLong(st.nextToken());
        }

        setTree(treeSize - 1);


        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());


            if (a == 1) {
                b = leafNode + b;
                changeVal(b,c);
            }
            else if (a == 2){
                b = leafNode + b;
                c = leafNode + c;
                long result = sumVal(b,(int)c);
                System.out.println(result);

            } else {
                return;
            }

        }

    }

    public static long sumVal(int start,int end) {
        long partSum = 0;

        while (start <= end) {
            if (start % 2 == 1) {
                partSum = partSum + tree[start];
                start++;
            }

            if (end % 2 == 0) {
                partSum = partSum + tree[end];
                end--;
            }
            start = start / 2;
            end = end / 2;
        }
        return partSum;

    }

    public static void changeVal(int index,long value) {
        long diff = value - tree[index];

        while (index > 0) {
            tree[index] = tree[index] + diff;
            index = index / 2;
        }
    }

    public static void setTree(int num) {
        while (num != 1) {
            tree[num/2] += tree[num];
            num--;
        }
    }
}