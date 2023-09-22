import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public String solution(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < sCharArray.length; i++) {
            map.put(sCharArray[i],map.getOrDefault(sCharArray[i],0)+1);
        }

        for (char temp : map.keySet()) {
            if (map.get(temp) == 1) {
                list.add(temp);
            }
        }

        Collections.sort(list);

        for (char temp : list) {
            sb.append(temp);
        }




    return sb.toString();
    }
}