class Solution {
    public void islandsAndTreasure(int[][] grid) {
        final int INF = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        int land = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
                if(grid[r][c] == INF) {
                    land++;
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i = 0; i < length; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                for(int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == INF) {
                        grid[newRow][newCol] = grid[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }
}
