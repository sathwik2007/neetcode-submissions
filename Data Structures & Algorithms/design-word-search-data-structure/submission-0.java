class Node {
    Node[] children = new Node[26];
    boolean isEOW = false;
}
class WordDictionary {
    private Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            if(i == word.length() - 1) {
                curr.children[idx].isEOW = true;
            }
            curr = curr.children[idx];
        }
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int index, Node root) {
        Node curr = root;
        for(int i = index; i < word.length(); i++) {
            if(word.charAt(i) == '.') {
                for(Node child : curr.children) {
                    if(child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = word.charAt(i) - 'a';
                if(curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }
        }
        return curr.isEOW;
    }
}
