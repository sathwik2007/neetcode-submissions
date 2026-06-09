class MinStack {
    private Stack s;
    private Stack minStack;

    public MinStack() {
        s = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        s.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, (int) minStack.peek()));
        }
    }
    
    public void pop() {
        int popValue = (int)s.pop();
        minStack.pop();
    }
    
    public int top() {
        return (int)s.peek();
    }
    
    public int getMin() {
        Integer minValue = (Integer)minStack.peek();
        return minValue.intValue();
    }
}
