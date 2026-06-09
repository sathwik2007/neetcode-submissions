class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> processed = new ArrayList<>();
        List<Integer> unprocessed = new ArrayList<>();
        for(int num : nums) {
            unprocessed.add(num);
        }
        helperFunc(unprocessed, processed, resList);
        return resList;
    }
    private static void helperFunc(List<Integer> unprocessed, List<Integer> processed, List<List<Integer>> resList) {
        if(unprocessed.isEmpty()) {
            resList.add(processed);
            return;
        }
        for(int i = 0; i < unprocessed.size(); i++) {
            List<Integer> newProcessed = new ArrayList<>(processed);
            newProcessed.add(unprocessed.get(i));
            List<Integer> newUnprocessed = new ArrayList<>(unprocessed);
            newUnprocessed.remove(i);
            helperFunc(newUnprocessed, newProcessed, resList);
        }
    }
}
