class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1) {
                    if(board[r][c] == 'O'){
                        dfs(board, r, c);
                    } 
                }
            }
        }
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(board[r][c] == 'V') {
                    board[r][c] = 'O';
                } else if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(char[][] board, int row, int col) {
        int ROWS = board.length, COLS = board[0].length;
        board[row][col] = 'V';
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && board[newRow][newCol] == 'O') {
                dfs(board, newRow, newCol);
            }
        }
    }
}
