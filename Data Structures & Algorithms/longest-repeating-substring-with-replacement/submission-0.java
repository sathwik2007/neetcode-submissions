class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int left = 0;
        int right = 0;
        int maxCount = 0;
        for(; right < s.length(); right++) {
            char ch = s.charAt(right);
            charCount[ch - 'A']++;

            maxCount = Math.max(maxCount, charCount[ch - 'A']);

            if(right - left + 1 > maxCount + k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return right - left;
    }
}
