

import java.util.*;

class Solution {

    public int[] solution(String[] park,String[] rotues) {
        char [][] map = new char[park.length][park[0].length()];
        int w = park.length;
        int h = park[0].length();
        int startx = 0;
        int starty = 0;

        for (int i = 0; i < park.length; i++) {
            String line = park[i];
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'S'){
                    startx = i;
                    starty = j;
                }
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < rotues.length; i++) {
            String[] line = rotues[i].split(" ");
            char pos = line[0].charAt(0);
            int count = Integer.parseInt(line[1]);
            int tempx = startx;
            int tempy = starty;
            boolean moveSuccess = true;

            for (int j = 0; j < count; j++) {
                if (pos == 'N') {
                   if (tempx-1 >= 0 && tempx-1 < w && map[tempx-1][tempy] == 'O') {
                       tempx--;
                   }
                   else{
                       moveSuccess = false;
                       break;
                   }

                }
                else if (pos == 'S') {
                    if (tempx+1 >= 0 && tempx+1 < w && map[tempx+1][tempy] == 'O') {
                        tempx++;
                    }
                    else{
                        moveSuccess = false;
                        break;
                    }
                }
                else if (pos == 'W') {
                    if (tempy-1 >= 0 && tempy-1 < h && map[tempx][tempy-1] == 'O'){
                        tempy--;

                    }else{
                        moveSuccess = false;
                        break;
                    }
                }
                else if (pos == 'E') {
                    if (tempy+1 >= 0 && tempy+1 < h && map[tempx][tempy+1] == 'O') {
                        tempy++;
                    }else{
                        moveSuccess = false;
                        break;
                    }
                }
            }
            if (moveSuccess) {
                map[startx][starty] = 'O'; 
                startx = tempx;
                starty = tempy;
                map[startx][starty] = 'S';
            }
        }



        int[] answer = new int[2];
        answer[0] = startx;
        answer[1] = starty;




        return answer;
    }


}




