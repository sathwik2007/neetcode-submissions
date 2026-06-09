class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] columnSet = new HashSet[9];
        HashSet<Character>[] boxSet = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            columnSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                char value = board[i][j];
                int boxIndex = (i / 3) * 3 + (j / 3);

                if(rowSet[i].contains(value) || columnSet[j].contains(value) || boxSet[boxIndex].contains(value)) {
                    return false;
                }
                rowSet[i].add(value);
                columnSet[j].add(value);
                boxSet[boxIndex].add(value);
            }
        }
        return true;

    }
}
