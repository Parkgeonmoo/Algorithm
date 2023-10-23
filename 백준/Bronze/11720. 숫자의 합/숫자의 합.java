import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String num = in.nextLine();
        int total = 0;

        for (int i = 0; i < num.length(); i++) {
            total += Integer.parseInt(num.substring(i,i+1));
        }

        System.out.println(total);



    }


}