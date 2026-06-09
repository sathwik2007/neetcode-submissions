class Solution {
    public int maxArea(int[] heights) {
        int maxAmount = 0;
        int i = 0, j = heights.length - 1;
        while(i < j) {
            maxAmount = Math.max(maxAmount, (j - i) * Math.min(heights[j], heights[i]));
            if(heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxAmount;
    }
}
