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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, int min, int max){
        if(node == null) return true;

        if(node.val <= min) return false;
        if(node.val >= max) return false;

        // int newMax = Math.max(max, node.val);
        // int newMin = Math.min(min, node.val);

        boolean isLeftTreeValid = dfs(node.left, min, node.val);
        boolean isRightTreeValid = dfs(node.right, node.val, max);

        return isLeftTreeValid && isRightTreeValid;
    }
}
