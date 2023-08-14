class Solution {
    int answer = 0;
    
    public int solution(int n) {
        int[] columns = new int[n];
        find(columns, 0);
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
    
    private void find(int[] columns, int row) {
        if (row == columns.length) {
            answer++;
            return;
        }
        
        for (int col = 0; col < columns.length; col++) {
            if (isValid(columns, row, col)) {
                columns[row] = col;
                find(columns, row + 1);
            }
        }
    }
}
