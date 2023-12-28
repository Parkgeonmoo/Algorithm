
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> temp = new HashSet<>();

        for (int i = 0; i < N; i++) {
            temp.add(br.readLine());
        }
        String[] words  = new String[temp.size()];
        temp.toArray(words);
        

        Arrays.sort(words ,(s1,s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            else {
                return Integer.compare(s1.length(),s2.length());
            }
        });


        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }


    }

}

