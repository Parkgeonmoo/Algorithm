
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int numOne = Integer.parseInt(st.nextToken());
            int numTwo = Integer.parseInt(st.nextToken());

            if (operation == 0) {
                union(numOne,numTwo);
            }
            else {
                if (checkSame(numOne,numTwo)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }




        }

        public static void union(int numOne,int numTwo) {
          numOne = find(numOne);
          numTwo = find(numTwo);

          if (numOne != numTwo) {
              parent[numTwo] = numOne;
          }
        }

        public static int find(int num) {
            if (parent[num] == num) {
                return num;
            }
            else {
                return parent[num] = find(parent[num]);
            }
        }

    public static boolean checkSame(int a,int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        }
        return false;
    }
    }
