class Solution {
    int answer = 0;
    
    public int solution(int n) {
        int[] columns = new int[n];
        placeQueens(columns, 0, n);
        return answer;
    }
    
    private boolean isValid(int[] columns, int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            if (columns[prevRow] == col || 
                Math.abs(columns[prevRow] - col) == Math.abs(prevRow - row)) {
                return false;
            }
        }
        return true;
    }
    
    private void placeQueens(int[] columns, int row, int n) {
        if (row == n) {
            answer++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isValid(columns, row, col)) {
                columns[row] = col;
                placeQueens(columns, row + 1, n);
            }
        }
    }
}