
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];
        int totalCount = 0;
        int midleCount = 0;
        int Min = Integer.MAX_VALUE;
        int Max = Integer.MIN_VALUE;
        int diff = 0;
        int freCount = 0;
        int freValue = 0;
        Map<Integer,Integer> count = new HashMap<>();
        ArrayList<Integer> freeans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            ans[i] = temp;
            totalCount += temp;
            if (temp < Min) {
                Min = temp;
            }
            if (temp > Max) {
                Max = temp;
            }
            count.put(temp,count.getOrDefault(temp,0) + 1);
        }
        Arrays.sort(ans);

        for (Map.Entry<Integer,Integer> entry : count.entrySet()) {
            if (entry.getValue() > freCount) {
                freeans = new ArrayList<>();
                freCount = entry.getValue();
                freValue = entry.getKey();
                freeans.add(freValue);
            }
            else if (entry.getValue() == freCount) {
                freValue = entry.getKey();
                freeans.add(freValue);
            }
        }
        Collections.sort(freeans);


        totalCount = (int) Math.round((double) totalCount / N);
        midleCount = ans[N / 2];

        diff = Max - Min;
        System.out.println(totalCount);
        System.out.println(midleCount);
        if (freeans.size() > 1) {
            System.out.println(freeans.get(1)); // 최빈값이 여러 개일 경우 두 번째로 작은 값 출력
        } else {
            System.out.println(freeans.get(0)); // 최빈값이 한 개일 경우 그 값 출력
        }
        System.out.println(diff);




    }
}
