
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> book = new HashMap<>();
        int max = -1;
        ArrayList<String> answerBookList = new ArrayList<>();
        String answerName = "";

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            book.put(temp,book.getOrDefault(temp,0)+1);
        }

        for (Map.Entry<String,Integer> answer : book.entrySet()) {
            if (answer.getValue() > max) {
                max = answer.getValue();
                answerBookList.clear();
                answerBookList.add(answer.getKey());
            }
            else if (answer.getValue() == max) {
                answerBookList.add(answer.getKey());
            }
            else {
                continue;
            }
        }
        Collections.sort(answerBookList);

        System.out.println(answerBookList.get(0));


    }
}
