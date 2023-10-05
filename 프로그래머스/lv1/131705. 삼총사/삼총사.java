
class Solution {
    public int solution(int[] number) {
        int result = 0;

        for (int i = 0; i < number.length; i++) {
            for (int j = i+1; j < number.length; j++) {
                for (int k = j+1; k < number.length; k++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }
                    if ((number[i] + number[j] + number[k]) == 0) {
                        result++;
                    }
                }
            }
        }


        return result;

    }


}






