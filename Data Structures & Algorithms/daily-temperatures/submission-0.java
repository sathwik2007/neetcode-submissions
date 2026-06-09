class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> tempStack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while(!tempStack.isEmpty() && temp > tempStack.peek()[0]) {
                int[] pair = tempStack.pop();
                result[pair[1]] = i - pair[1];
            }
            tempStack.push(new int[]{temp, i});
        }
        return result;
    }
}
