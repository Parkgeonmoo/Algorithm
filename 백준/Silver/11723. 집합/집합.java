import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int bitmask = 0;

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String order = input[0];

            if (order.equals("add")) {
                int num = Integer.parseInt(input[1]);
                bitmask |= (1 << (num - 1));
            }
            else if (order.equals("remove")) {
                int num = Integer.parseInt(input[1]);
                bitmask &= ~(1 << (num - 1));
            }
            else if (order.equals("check")) {
                int num = Integer.parseInt(input[1]);
                if ((bitmask & (1 << (num - 1))) != 0) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else if (order.equals("toggle")) {
                int num = Integer.parseInt(input[1]);
                bitmask ^= (1 << (num - 1));
            }
            else if (order.equals("all")) {
                bitmask = (1 << 20) - 1;
            }
            else {
                bitmask = 0;
            }
        }
        System.out.print(sb.toString());
    }
}
