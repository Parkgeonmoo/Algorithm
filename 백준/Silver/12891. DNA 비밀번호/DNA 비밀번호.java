
import java.util.*;
import java.io.*;

public class Main {
    public static int[] checkArr;
    public static int[] myArr;
    public static int checkResult;
    public static int Result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        char[] now = s.toCharArray();
        st = new StringTokenizer(br.readLine());

        checkArr = new int[4];
        myArr = new int[4];
        checkResult = 0;


        for (int i = 0; i < 4; i++) {
          checkArr[i] = Integer.parseInt(st.nextToken());
          if (checkArr[i] == 0) {
              checkResult++;
          }
        }

        for (int i = 0; i < P; i++) {
            Add(now[i]);
        }

        if (checkResult == 4) {
            Result++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(now[i]);
            Remove(now[j]);
            if (checkResult == 4) {
                Result++;
            }
        }
        System.out.println(Result);



    }

    public static void Add(char c) {
        switch (c) {
            case 'A' :
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkResult++;
                }
                break;
            case 'C' :
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkResult++;
                }
                break;
            case 'G' :
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkResult++;
                }
                break;
            case 'T' :
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkResult++;
                }
                break;
        }

    }

    public static void Remove(char c) {
        switch(c) {
            case 'A' :
                if (myArr[0] == checkArr[0]) {
                    checkResult--;
                }
                myArr[0]--;
                break;
            case 'C' :
                if (myArr[1] == checkArr[1]) {
                    checkResult--;
                }
                myArr[1]--;
                break;
            case 'G' :
                if (myArr[2] == checkArr[2]) {
                    checkResult--;
                }
                myArr[2]--;
                break;
            case 'T' :
                if (myArr[3] == checkArr[3]) {
                    checkResult--;
                }
                myArr[3]--;
                break;
        }
    }
}

