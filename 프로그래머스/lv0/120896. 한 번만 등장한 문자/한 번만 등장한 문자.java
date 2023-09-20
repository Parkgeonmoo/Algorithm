import java.util.*;


class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        ArrayList<Character> check = new ArrayList<>();

        Map<Character,Integer> map = new HashMap<>();

        char[] temp = s.toCharArray();

        for (int i = 0; i < temp.length; i++) {
            map.put(temp[i],map.getOrDefault(temp[i],0) +1);
        }



        for (char c : map.keySet()) {
            int count = map.get(c);
            if (count == 1) {
                check.add(c);
            }
        }

        Collections.sort(check);

        for (char c : check) {
            sb.append(c);
        }


        return sb.toString();
    }
}
