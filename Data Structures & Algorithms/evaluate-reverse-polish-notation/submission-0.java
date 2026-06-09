class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(String token : tokens) {
            if(token.equals("+")) {
                int num2 = s.pop();
                int num1 = s.pop();
                int res = num1 + num2;
                s.push(res);
            } else if(token.equals("-")) {
                int num2 = s.pop();
                int num1 = s.pop();
                int res = num1 - num2;
                s.push(res);
            } else if(token.equals("*")) {
                int num2 = s.pop();
                int num1 = s.pop();
                int res = num1 * num2;
                s.push(res);
            } else if(token.equals("/")) {
                int num2 = s.pop();
                int num1 = s.pop();
                int res = (int) num1 / num2;
                s.push(res);
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.peek();
    }
}
