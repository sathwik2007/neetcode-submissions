class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        for(char ch : s1.toCharArray()) {
            s1Count[ch - 'a']++;
        }
        int n = s1.length();
        int left = 0;
        int right = left + n - 1;
        while(right < s2.length()) {
            int[] s2Count = new int[26];
            for(int i = left; i <= right; i++) {
                s2Count[s2.charAt(i) - 'a']++;
            }
            if(Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}
