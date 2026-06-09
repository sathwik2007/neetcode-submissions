class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length - 1;
        int row = 0;
        for(int i = 0; i < matrix.length; i++) {
            if(target <= matrix[i][n]) {
                row = i;
                break;
            }
        }
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(matrix[row][mid] < target) {
                low = mid + 1;
            } else if(matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
