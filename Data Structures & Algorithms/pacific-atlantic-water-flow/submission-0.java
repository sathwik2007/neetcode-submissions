class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        for(int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific, -1);
            dfs(heights, ROWS - 1, c, atlantic, -1);
        }
        for(int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific, -1);
            dfs(heights, r, COLS - 1, atlantic, -1);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(r);
                    temp.add(c);
                    result.add(temp);
                }
            }
        }
        return result;
    }
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        if(row < 0 || row == heights.length || col < 0 || col == heights[0].length || visited[row][col] || heights[row][col] < prevHeight) {
            return;
        }
        visited[row][col] = true;
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(heights, newRow, newCol, visited, heights[row][col]);
        }
    }
}
