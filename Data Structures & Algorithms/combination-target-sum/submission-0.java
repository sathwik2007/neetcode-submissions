class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> processed = new ArrayList<>();
        helperFunc(nums, processed, resList, target);
        return resList;
    }
    private static void helperFunc(int[] nums, List<Integer> processed, List<List<Integer>> resList, int target) {
        int sum = 0;
        for(int num : processed) {
            sum += num;
        }
        if(sum == target) {
            Collections.sort(processed);
            if(!resList.contains(processed)) {
                resList.add(processed);
            }
            return;
        } else if(sum > target) {
            return;
        }
        for(int num : nums) {
            List<Integer> newProcessed = new ArrayList(processed);
            newProcessed.add(num);
            helperFunc(nums, newProcessed, resList, target);
        }
    }
}
