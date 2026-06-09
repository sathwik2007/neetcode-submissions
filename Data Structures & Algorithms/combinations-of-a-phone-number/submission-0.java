class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        String processed = "";
        List<String> resList = new ArrayList<>();
        if(digits.isEmpty()) {
            return resList;
        }
        helperFunc(digits, processed, resList, map);
        return resList;
    }
    private static void helperFunc(String unprocessed, String processed, List<String> resList, Map<Character, String> map) {
        if(unprocessed.isEmpty()) {
            resList.add(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        String temp = map.get(ch);
        for(char c : temp.toCharArray()) {
            helperFunc(unprocessed.substring(1), processed + c, resList, map);
        }
    }
}
