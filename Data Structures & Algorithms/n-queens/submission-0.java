class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        helperFunc(board, 0, result);
        return result;
    }
    private static void helperFunc(boolean[][] board, int row, List<List<String>> result) {
        if(row == board.length) {
            List<String> temp = convertToString(board);
            result.add(temp);
            return;
        }
        for(int col = 0; col < board[0].length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = true;
                helperFunc(board, row + 1, result);
                board[row][col] = false;
            }
        }
    }
    private static boolean isSafe(boolean[][] board, int row, int col) {
        int tempRow = row;
        int tempCol = col;
        while(tempRow > 0) {
            if(board[tempRow-1][tempCol]) {
                return false;
            }
            tempRow--;
        }
        tempRow = row;
        tempCol = col;
        while(tempRow > 0 && tempCol > 0) {
            if(board[tempRow-1][tempCol-1]) {
                return false;
            }
            tempRow--;
            tempCol--;
        }
        tempRow = row;
        tempCol = col;
        while(tempRow > 0 && tempCol < board.length - 1) {
            if(board[tempRow-1][tempCol+1]) {
                return false;
            }
            tempRow--;
            tempCol++;
        }
        return true;
    }
    private static List<String> convertToString(boolean[][] board) {
        List<String> temp = new ArrayList<>();
        for(int row = 0; row < board.length; row++) {
            StringBuilder str = new StringBuilder();
            for(int col = 0; col < board[0].length; col++) {
                if(board[row][col]) {
                    str.append('Q');
                } else {
                    str.append('.');
                }
            }
            temp.add(str.toString());
        }
        return temp;
    }
}
