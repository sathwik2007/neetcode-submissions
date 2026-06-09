class Solution {
    public int trap(int[] height) {
        int maxArea = 0;
        if(height.length <= 1) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        while(left < right) {
            if(maxLeft <= maxRight) {
                left++;
                int currArea = Math.min(maxLeft, maxRight) - height[left];
                if(currArea > 0) {
                    maxArea += currArea;
                }
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                right--;
                int currArea = Math.min(maxLeft, maxRight) - height[right];
                if(currArea > 0) {
                    maxArea += currArea;
                }
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return maxArea;
    }
}
