class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> numsCount = new HashMap<>();
        for(int num : nums) {
            numsCount.put(num, numsCount.getOrDefault(num, 0) + 1);
        }
        for(int key : numsCount.keySet()) {
            if(numsCount.get(key) > 1) {
                return key;
            }
        }
        return 0;
    }
}
