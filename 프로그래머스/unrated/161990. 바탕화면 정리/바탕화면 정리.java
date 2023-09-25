
import java.util.*;

class Solution {

    public int[] solution(String[] wallpaper) {
        char[][] drag = new char[wallpaper.length][wallpaper[0].length()];

        for (int i = 0; i < wallpaper.length; i++) {
            String line = wallpaper[i];
            char[]temp = line.toCharArray();

            for (int j = 0; j < temp.length; j++) {
                drag[i][j] = temp[j];
            }
        }
        int minX = 10000000;
        int minY = 10000000;
        int maxX = -10000000;
        int maxY = -10000000;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (drag[i][j] == '#') {
                    if (i < minX) {
                        minX = i;
                    }
                    if (j < minY) {
                        minY = j;
                    }
                    if (i > maxX) {
                        maxX = i;
                    }
                    if (j > maxY) {
                        maxY = j;
                    }
                }
            }
        }

        int[] result = new int[4];
        result[0] = minX;
        result[1] = minY;
        result[2] = maxX+1;
        result[3] = maxY+1;


        return result;
    }


}




