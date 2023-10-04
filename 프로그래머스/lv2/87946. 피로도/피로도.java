
class Solution {
    public int solution(int k , int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return btk(k, dungeons, 0, visited);
    }

    public int btk(int k,int[][] dungeons,int count,boolean[] visited) {
        if (count == dungeons.length) {
            return 0;
        }

        int maxDungeons = 0;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                maxDungeons = Math.max(maxDungeons, 1 + btk(k - dungeons[i][1],dungeons,count+1,visited));
                visited[i] = false; // restore the original state
            }
        }

        return maxDungeons;
    }
}






