import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        int maxCount = 0;		// 최빈값
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();		// HashMap 선언 : new에서 타입 파라미터 생략가능

        for (int number : array) {

            map.put(number,map.getOrDefault(number, 0) + 1);

            if (map.get(number) > maxCount) {		// 최빈값이 1개 일 경우
                maxCount = map.get(number);
                answer = number;
            } else if (map.get(number) == maxCount) {		// 최빈값이 여러개(2개 이상)일 경우
                answer = -1;
            }


        }
        return answer;
    }
}
