
import java.util.*;

class Solution {
    Map<String, ArrayList<Integer>> infos = new HashMap<>();

    void combination(String[] info, int depth, String s) {
        if (depth == 4) {
            if (!infos.containsKey(s)) infos.put(s, new ArrayList<>());
            infos.get(s).add(Integer.parseInt(info[4]));
            return;
        }

        combination(info, depth + 1, s + "-");
        combination(info, depth + 1, s + info[depth]);
    }

    public int[] solution(String[] infoArr, String[] queryArr) {
        for (String in : infoArr) {
            String[] info = in.split(" ");
            combination(info, 0, "");
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : infos.entrySet())
            entry.getValue().sort(null);

        int[] answer = new int[queryArr.length];

        for (int i = 0; i < queryArr.length; i++) {
            String[] query = queryArr[i].split(" ");
            String key = query[0] + query[2] + query[4] + query[6];

            if (infos.containsKey(key)) {
                ArrayList<Integer> arrayList = infos.get(key);
                int start = 0;
                int end = arrayList.size();

                // binary search
                int score = Integer.parseInt(query[7]);

                while (start < end) {
                    int mid = (start + end) / 2;

                    if (arrayList.get(mid) < score)
                        start = mid + 1;
                    else
                        end = mid;
                }

                answer[i] = arrayList.size() - start;
            } else answer[i] = 0;


        }
        return answer;


    }
}





