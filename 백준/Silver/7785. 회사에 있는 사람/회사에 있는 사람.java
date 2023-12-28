
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        HashSet<String> currentlyInCompany = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String people = st.nextToken();
            String method = st.nextToken();

            if (method.equals("enter")) {
                currentlyInCompany.add(people);
            } else {
                currentlyInCompany.remove(people);
            }
        }

        List<String> answer = new ArrayList<>(currentlyInCompany);
        answer.sort(Collections.reverseOrder());

        for (String temp : answer) {
            System.out.println(temp);
        }
    }
}
