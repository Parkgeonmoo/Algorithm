import java.util.Scanner;

public class Main{

    public static void main(String[]args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] map = s.split("-");
        int sum = 0;

        for (int i = 0; i < map.length; i++) {
            int temp = mySum(map[i]);
            if (i == 0) {
               sum  = sum + temp;
            }else{
                sum = sum - temp;
            }

        }
        System.out.println(sum);

        }
    static int mySum(String a) {
        int sum = 0;
        String temp[] = a.split("[+]");
        for (int i = 0; i < temp.length;i++) {
            sum += Integer.parseInt(temp[i]);

    }
        return sum;
    }
}