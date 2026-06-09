class Solution {
    private void helperFunc(int openN, int closedN, int n, List<String> result, StringBuilder s) {
        if(openN == closedN && openN == n) {
            result.add(s.toString());
            return;
        }
        if(openN < n) {
            s.append('(');
            helperFunc(openN + 1, closedN, n, result, s);
            s.deleteCharAt(s.length() - 1);
        }
        if(closedN < openN) {
            s.append(')');
            helperFunc(openN, closedN + 1, n, result, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        helperFunc(0, 0, n, result, s);
        return result;
    }
}
