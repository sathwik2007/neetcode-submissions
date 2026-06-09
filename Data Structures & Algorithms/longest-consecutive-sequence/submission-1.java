class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int maxLength = 1;
        if(nums.length == 0) {
            return 0;
        }
        for(int num : nums) {
            numSet.add(num);
        }
        for(int num : nums) {
            if(!numSet.contains(num - 1)) {
                int currLength = 1;
                while(numSet.contains(num + 1)) {
                    currLength++;
                    num++;
                }
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }
}
