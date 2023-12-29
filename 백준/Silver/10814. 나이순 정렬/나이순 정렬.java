
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        User[] users;
        int N = Integer.parseInt(br.readLine());
        users = new User[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users[i] = new User(age,name);
        }

        Arrays.sort(users,new Comparator<User>(){
            public int compare(User a1,User a2) {
                return a1.age - a2.age;
            }
        });

        for (User temp : users) {
            System.out.println(temp.age + " " + temp.name);
        }





    }
    static class User{
        int age;
        String name;

        public User(int age,String name) {
            this.age = age;
            this.name = name;
        }
    }
}
