class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> resList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helperFunc(s, 0, resList, temp);
        return resList;
    }
    private static void helperFunc(String s, int index, List<List<String>> resList, List<String> temp) {
        if(index == s.length()) {
            resList.add(new ArrayList<>(temp));
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s.substring(index, i + 1))) {
                temp.add(s.substring(index, i + 1));
                helperFunc(s, i + 1, resList, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
