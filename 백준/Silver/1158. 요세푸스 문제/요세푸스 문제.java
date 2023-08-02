import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] tokens = line.split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        ArrayList<Integer> peoplecheck = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int nowindex = 0;

        for (int i = 1; i <= N; i++) {
            peoplecheck.add(i);
        }

        System.out.print("<");
        for (int i = 0; i < N; i++) {
            nowindex = (nowindex + K) - 1;
            while (nowindex >= peoplecheck.size()) {
                nowindex = nowindex - peoplecheck.size();
            }
            System.out.print(peoplecheck.remove(nowindex));
            if (!peoplecheck.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
