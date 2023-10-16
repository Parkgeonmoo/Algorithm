import java.util.Scanner;

public class Main{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] map = new int[10000001];

        for (int i = 2; i < map.length; i++) {
            map[i] = i;
        }

        for (int i = 2; i < Math.sqrt(map.length); i++) {
            if (map[i] == 0){
                continue;
            }
            for (int j = i+i; j < map.length; j = j+i) {
                map[j] = 0;
            }
        }

        int i = N;
        while(true) {
            if (map[i] != 0) {
                int temp = map[i];
                if (pallen(temp)) {
                    System.out.println(temp);
                    break;
                }

            }
            i++;
        }
    }
    public static boolean pallen(int target) {
        char[] temp = String.valueOf(target).toCharArray();
        int index1 = 0;
        int index2 = temp.length-1;

        while (index1 < index2) {
            if (temp[index1] != temp[index2])
                return false;
            index1++;
            index2--;
        }
        return true;
    }
}