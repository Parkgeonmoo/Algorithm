import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Egg[] eggs;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int index) {
        if (index == N) {
            int count = 0;
            for (Egg egg : eggs) {
                if (egg.Durability <= 0) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        if (eggs[index].Durability <= 0) {
            dfs(index + 1);
            return;
        }

        boolean canBreak = false;

        for (int i = 0; i < N; i++) {
            if (i == index || eggs[i].Durability <= 0) {
                continue;
            }

            canBreak = true;

            eggs[index].Durability -= eggs[i].weight;
            eggs[i].Durability -= eggs[index].weight;

            dfs(index + 1);

            eggs[index].Durability += eggs[i].weight;
            eggs[i].Durability += eggs[index].weight;
        }

        if (!canBreak) {
            dfs(index + 1);
        }
    }
}

class Egg {
    int Durability;
    int weight;

    Egg(int Durability, int weight) {
        this.Durability = Durability;
        this.weight = weight;
    }
}
