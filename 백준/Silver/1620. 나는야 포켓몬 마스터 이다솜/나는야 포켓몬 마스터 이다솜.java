
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameToIndex = new HashMap<>();
        HashMap<Integer, String> indexToName = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            nameToIndex.put(temp, i);
            indexToName.put(i, temp);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            try {
                int number = Integer.parseInt(input);
                System.out.println(indexToName.get(number));
            } catch (NumberFormatException e) {
                System.out.println(nameToIndex.get(input));
            }
        }
    }
}
