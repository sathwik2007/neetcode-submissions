class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    int temp = bfs(grid, r, c);
                    result = Math.max(result, temp);
                }
            }
        }
        return result;
    }

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int bfs(int[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        grid[row][col] = 0;
        queue.offer(new int[]{row, col});
        int temp = 0;
        temp++;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] direction : directions) {
                int newRow = r + direction[0];
                int newCol = c + direction[1];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 0;
                    temp++;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return temp;
    }
}
