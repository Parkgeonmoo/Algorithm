
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String check = br.readLine();

        int count = 0;
        int index = 0;

        while (index <= origin.length() - check.length()) {
            if (origin.substring(index, index + check.length()).equals(check)) {
                count++;
                index += check.length();
            } else {
                index++;
            }
        }

        System.out.println(count);
    }
}

