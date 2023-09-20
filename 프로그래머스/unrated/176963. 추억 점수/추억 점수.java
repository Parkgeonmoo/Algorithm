import java.util.HashMap;
import java.util.Map;


class Solution {
    public int[] solution(String[] name, int [] yearning,String[][] photo) {
        int[] result = new int[photo.length];
        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i],yearning[i]);
        }

        int idx = 0;
        for (String[] tempArray : photo) {
            int count = 0;

            for (String tempName : tempArray) {
                if (map.containsKey(tempName)) {
                    count += map.get(tempName);
                }
            }
            result[idx] = count;
            idx++;
        }

     return result;
    }
}