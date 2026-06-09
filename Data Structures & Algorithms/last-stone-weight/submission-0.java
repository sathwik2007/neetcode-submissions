class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) {
            queue.offer(stone);
        }
        while(queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            if(first == second) {
                continue;
            } else {
                queue.offer(Math.abs(first - second));
            }
        }
        return queue.size() == 1 ? queue.peek() : 0;
    }
}
