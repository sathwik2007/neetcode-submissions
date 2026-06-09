class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char ch : t.toCharArray()) {
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }

        int have = 0, need = tCount.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(tCount.containsKey(ch) && window.get(ch).equals(tCount.get(ch))) {
                have++;
            }

            while(have == need) {
                if((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if(tCount.containsKey(leftChar) && window.get(leftChar) < tCount.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
