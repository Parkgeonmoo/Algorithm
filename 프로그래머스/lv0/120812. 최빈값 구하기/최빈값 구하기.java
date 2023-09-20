import java.util.*;

class Solution {
    public int solution(int[] array) {
        int maxCount = 0;		// 최빈값
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();		// HashMap 선언 : new에서 타입 파라미터 생략가능
        
        for (int number : array) {
            int count = map.getOrDefault(number, 0) + 1;
            
            if (count > maxCount) {		// 최빈값이 1개 일 경우
                maxCount = count;
                answer = number;
            } else if (count == maxCount) {		// 최빈값이 여러개(2개 이상)일 경우
                answer = -1;
            }
            
            map.put(number, count);		// 값 추가 : number 키와 이와 매핑된 count 값을 추가한다
        }
        return answer;
    }
}