
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static java.util.Collections.reverseOrder;

class Solution {
    public String solution(String X,String Y) {

        HashMap<Character,Integer> xMap = new HashMap<>();
        HashMap<Character,Integer> yMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] XArray = X.toCharArray();
        char[] YArray = Y.toCharArray();

        for (int i = 0; i < XArray.length; i++) {
            xMap.put(XArray[i],xMap.getOrDefault(XArray[i],0)+1);
        }

        for (int i = 0; i < YArray.length; i++) {
            yMap.put(YArray[i],yMap.getOrDefault(YArray[i],0)+1);
        }

        for (Character temp: xMap.keySet()) {
            if (yMap.containsKey(temp)) {
                int iter = Math.min(yMap.get(temp),xMap.get(temp));
                for (int i = 0; i < iter; i++) {
                    list.add(temp - '0');
                }
            }
        }

        Collections.sort(list,reverseOrder());

        if (!list.isEmpty() && list.get(0) == 0) {
            return "0"; // Return "0"
        } else if(list.isEmpty()) {
            return "-1";
        }



        for (int i : list) {
            sb.append(i);
        }

        return sb.toString();

    }


}






