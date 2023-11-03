
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    static int M,N;
    static int[] map,check;

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        map = new int[N];

        for (int i = 0; i < N; i++) {
            map[i] = in.nextInt();
        } // 기본 배열 입력
        Arrays.sort(map); // 맵 정렬

        int M = in.nextInt();
        check = new int[M];

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = in.nextInt();
            //찾아야 할 숫자 배열 입력

            int start = 0;
            int end = map.length - 1;
            while (start <= end) {
                int midi = (start+end)/2;
                int midV = map[midi];
                if(midV > target) {
                    end = midi -1;
                }
                else if(midV < target){
                    start = midi +1;
                }else{
                    find= true;
                    break;
                }
            }
            if(find) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }

        }



    }
}