
import java.util.*;


class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Integer> map =new ArrayList<>();
        HashMap<Integer,Integer> hashmap= new HashMap<>();

        for (int i = 0; i < rank.length; i++) {
            hashmap.put(rank[i],i);
        }

        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]){
                map.add(rank[i]);
            }
        }

        Collections.sort(map);

        int a = hashmap.getOrDefault(map.get(0),0);
        int b = hashmap.getOrDefault(map.get(1),0);
        int c = hashmap.getOrDefault(map.get(2),0);

        int answer = 10000*a + 100 *b + c;
        return answer;
    }
}