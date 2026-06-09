class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> processed = new ArrayList<>();
        List<Integer> unprocessed = new ArrayList<>();
        for(int candidate : candidates) {
            unprocessed.add(candidate);
        }
        helperFunc(unprocessed, processed, resList, target);
        return resList;
    }
    private static void helperFunc(List<Integer> unprocessed, List<Integer> processed, List<List<Integer>> resList, int target) {
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
        for(int i = 0; i < unprocessed.size(); i++) {
            List<Integer> newProcessed = new ArrayList<>(processed);
            newProcessed.add(unprocessed.get(i));
            List<Integer> newUnprocessed = new ArrayList<>(unprocessed);
            newUnprocessed.remove(i);
            helperFunc(newUnprocessed, newProcessed, resList, target);
        }
    }
}
