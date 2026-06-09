class Solution {
    private boolean isAlphaNumeric(char ch) {
        if((ch >= 48 && ch <= 57) || (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("\\s", "");
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(!isAlphaNumeric(s.charAt(i)) && !isAlphaNumeric(s.charAt(j))) {
                i++;
                j--;
            } else if(!isAlphaNumeric(s.charAt(i))) {
                i++;
            } else if(!isAlphaNumeric(s.charAt(j))) {
                j--;
            } else {
                if(s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            } 
        }
        return true;
    }
}
