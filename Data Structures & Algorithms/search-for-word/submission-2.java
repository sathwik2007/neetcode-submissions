class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int idx = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(helperFunc(board, i, j, idx, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean helperFunc(char[][] board, int row, int col, int idx, String word) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
        return false;
    }

    if (board[row][col] != word.charAt(idx)) {
        return false;
    }

    if (idx == word.length() - 1) {
        return true;
    }

    char ch = board[row][col];
    board[row][col] = '#';
    
    boolean res =
        helperFunc(board, row - 1, col, idx + 1, word) ||
        helperFunc(board, row + 1, col, idx + 1, word) ||
        helperFunc(board, row, col - 1, idx + 1, word) ||
        helperFunc(board, row, col + 1, idx + 1, word);

    board[row][col] = ch;
    return res;
    }
}
