class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int res = Integer.MAX_VALUE;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            int totalHours = 0;
            for(int i = 0; i < piles.length; i++) {
                totalHours += Math.ceil((double) piles[i] / mid);
            }
            if(totalHours <= h) {
                res = Math.min(res, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
