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

class Solution {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helperFunc(root);
        return result;
    }
    private int helperFunc(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftMax = Math.max(0, helperFunc(root.left));
        int rightMax = Math.max(0, helperFunc(root.right));
        result = Math.max(result, leftMax + rightMax + root.val);
        return Math.max(leftMax, rightMax) + root.val;
    }
}
