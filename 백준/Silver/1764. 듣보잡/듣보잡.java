
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> noListen = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            noListen.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String noSee = br.readLine();
            if (noListen.contains(noSee)) {
                answer.add(noSee);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());

        for (String temp : answer) {
            System.out.println(temp);
        }
    }
}
