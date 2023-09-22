import java.util.*;




public class Solution {

    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> map = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            map.add(arr[i]);
        }

        for (int i = 0; i < delete_list.length; i++) {
            map.remove((Integer)delete_list[i]);
        }

        int[] result = new int[map.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(i);
        }

        return result;
    }
}