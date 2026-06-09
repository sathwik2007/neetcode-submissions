class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    fresh++;
                }
                if(grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(fresh > 0 && !queue.isEmpty()) {
            int length = queue.size();
            for(int i = 0; i < length; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] direction : directions) {
                    int newRow = r + direction[0];
                    int newCol = c + direction[1];
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
