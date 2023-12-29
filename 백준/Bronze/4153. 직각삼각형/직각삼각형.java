
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int side1 = Integer.parseInt(st.nextToken());
            int side2 = Integer.parseInt(st.nextToken());
            int side3 = Integer.parseInt(st.nextToken());

            if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
                break;
            }


            if((side1 * side1 + side2 * side2) == side3 * side3) {
                System.out.println("right");
            }
            else if(side1 * side1 == (side2 * side2 + side3 * side3)) {
                System.out.println("right");
            }
            else if(side2 * side2 == (side3 * side3 + side1 * side1)) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
            
        }
    }
}
