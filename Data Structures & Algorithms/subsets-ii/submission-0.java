class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> external = new ArrayList<>();
        external.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0; i < nums.length; i++) {
            start = 0;
            if(i > 0 && nums[i] == nums[i-1]) {
                start = end + 1;
            }
            end = external.size() - 1;
            for(int j = start; j <= end; j++) {
                List<Integer> internal = new ArrayList<>(external.get(j));
                internal.add(nums[i]);
                external.add(internal);
            }
        }
        return external;
    }
}
