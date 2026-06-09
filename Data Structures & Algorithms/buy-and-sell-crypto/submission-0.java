class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = left + 1;
        while(right < prices.length){
            int currProfit = prices[right] - prices[left];
            if(currProfit < 0) {
                left = right;
                right = left + 1;
            } else {
                maxProfit = Math.max(maxProfit, currProfit);
                right++;
            }
        }
        return maxProfit;
    }
}
