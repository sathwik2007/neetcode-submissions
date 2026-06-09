/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helperFunc(root, list);
        String data = String.join("#", list);
        return data;
    }

    private void helperFunc(TreeNode root, List<String> list) {
        if(root == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(root.val));
        helperFunc(root.left, list);
        helperFunc(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.split("#")));
        Collections.reverse(list);
        TreeNode root = helperFunc2(list);
        return root;
    }

    private TreeNode helperFunc2(List<String> list) {
        String value = list.remove(list.size() - 1);
        if(value.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = helperFunc2(list);
        node.right = helperFunc2(list);
        return node;
    }
}
