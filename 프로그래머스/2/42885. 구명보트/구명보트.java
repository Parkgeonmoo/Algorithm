import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        int answer = 0;
        Arrays.sort(people);
        
       int left = 0;  // 구명보트의 왼쪽 끝 인덱스
        int right = people.length - 1;  // 구명보트의 오른쪽 끝 인덱스

        while (left <= right) {
            // 가장 무거운 사람과 가장 가벼운 사람을 함께 태우는 경우
            if (people[left] + people[right] <= limit) {
                left++;  // 왼쪽 끝 인덱스를 한 칸 오른쪽으로 이동
            }

            right--;  // 오른쪽 끝 인덱스를 한 칸 왼쪽으로 이동
            answer++;  // 구명보트의 개수 증가
        }
        
        return answer;
    }
}