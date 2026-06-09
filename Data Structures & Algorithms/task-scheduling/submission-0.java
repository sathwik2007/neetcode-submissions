class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int c : count) {
            if(c > 0) {
                maxHeap.add(c);
            }
        }
        int times = 0;
        Queue<int[]> queue = new LinkedList<>();
        while(!queue.isEmpty() || !maxHeap.isEmpty()) {
            times++;
            if(maxHeap.isEmpty()) {
                times = queue.peek()[1];
            } else {
                int c = maxHeap.poll() - 1;
                if(c > 0) {
                    queue.add(new int[]{c, times + n});
                }
            }

            if(!queue.isEmpty() && queue.peek()[1] == times) {
                maxHeap.add(queue.poll()[0]);
            }
        }

        return times;
    }
}
