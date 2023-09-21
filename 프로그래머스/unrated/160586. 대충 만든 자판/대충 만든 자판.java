import java.util.HashMap;
import java.util.Map;




class Solution {
    public int[] solution(String[] keymap, String[]targets) {
        int[] result = new int[targets.length];
        Map<Character,Integer> key = new HashMap<>();
        Map<Character,Integer> target  = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            String line = keymap[i];
            char[] temp = line.toCharArray();

            for (int j = 0; j < temp.length; j++) {
                char tempChar = temp[j];
                if (!key.containsKey(tempChar) || j < key.get(tempChar)) {
                    key.put(tempChar,j+1);
                }

            }

        }

        for (int i = 0; i < targets.length; i++) {
            String line = targets[i];
            char[] temp = line.toCharArray();
            int count = 0;
            for (int j = 0; j < temp.length; j++) {
                char tempChar = temp[j];
                if (key.containsKey(tempChar)) {
                    count += key.get(tempChar);
                }else{
                    count = -1;
                    break;
                }
            }
            result[i] = count;
        }


     return result;
    }
}