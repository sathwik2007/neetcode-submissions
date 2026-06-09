class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> unprocessed = new ArrayList<>();
        for(int num : nums) {
            unprocessed.add(num);
        }
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> processed = new ArrayList<>();
        helperFunc(unprocessed, processed, resList);
        return resList;
    }
    private static void helperFunc(List<Integer> unprocessed, List<Integer> processed, List<List<Integer>> resList) {
        if(unprocessed.isEmpty()) {
            resList.add(processed);
            return;
        }
        int num = unprocessed.get(0);
        List<Integer> newProcessed = new ArrayList<>(processed);
        newProcessed.add(num);
        List<Integer> newUnprocessed = new ArrayList<>(unprocessed);
        newUnprocessed.remove(0);
        helperFunc(newUnprocessed, processed, resList);
        helperFunc(newUnprocessed, newProcessed, resList);
    }
}