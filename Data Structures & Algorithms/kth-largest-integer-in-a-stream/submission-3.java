class KthLargest {
    List<Integer> list;
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        list = new ArrayList();
        for(int num : nums) {
            list.add(num);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size() - K);
    }
}
