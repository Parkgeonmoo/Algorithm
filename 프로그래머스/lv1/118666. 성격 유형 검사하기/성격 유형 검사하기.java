
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static java.util.Collections.reverseOrder;

class Solution {
    public String solution(String[] survey,int[] choices) {

        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list;

        char[][] type = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};

        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);

        for (int i = 0; i < survey.length; i++) {
            char[] temp = survey[i].toCharArray();

            int value = choices[i];

            switch (value) {
                case 1:
                    map.put(temp[0],map.getOrDefault(temp[0],0)+3);
                    map.put(temp[1],map.getOrDefault(temp[1],0)+0);
                    break;
                case 2:
                    map.put(temp[0],map.getOrDefault(temp[0],0)+2);
                    map.put(temp[1],map.getOrDefault(temp[1],0)+0);
                    break;
                case 3:
                    map.put(temp[0],map.getOrDefault(temp[0],0)+1);
                    map.put(temp[1],map.getOrDefault(temp[1],0)+0);
                    break;
                case 4:
                    map.put(temp[0],map.getOrDefault(temp[0],0)+0);
                    map.put(temp[1],map.getOrDefault(temp[1],0)+0);
                    break;
                case 5:
                    map.put(temp[1],map.getOrDefault(temp[1],0)+1);
                    map.put(temp[0],map.getOrDefault(temp[0],0)+0);
                    break;
                case 6:
                    map.put(temp[1],map.getOrDefault(temp[1],0)+2);
                    map.put(temp[0],map.getOrDefault(temp[0],0)+0);
                    break;
                case 7:
                    map.put(temp[1],map.getOrDefault(temp[1],0)+3);
                    map.put(temp[0],map.getOrDefault(temp[0],0)+0);
                    break;
            }

        }

        for (int i = 0; i < type.length; i++) {
            if (map.get(type[i][0]) < map.get(type[i][1])) {
                sb.append(type[i][1]);
            }
            else if (map.get(type[i][0]) > map.get(type[i][1])) {
                sb.append(type[i][0]);
            }
            else {
                list = new ArrayList<>();
                list.add(type[i][0]);
                list.add(type[i][1]);
                Collections.sort(list);
                sb.append(list.get(0));
            }
        }






        return sb.toString();
    }

}






