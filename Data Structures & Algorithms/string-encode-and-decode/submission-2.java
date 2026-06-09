class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for(String str: strs) {
            encodedStr.append(Integer.toString(str.length())).append("#").append(str);
        }
        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        while(idx < str.length()) {
            int j = idx;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(idx, j));
            result.add(str.substring(j + 1, j + 1 + len));
            idx = j + 1 + len;
        }
        return result;
    }
}
