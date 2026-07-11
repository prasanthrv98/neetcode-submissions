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
    public boolean isBalanced(TreeNode root) {
        int diff = dfs(root);

        if(diff < 0) return false;
        else return true;
    }

    public int dfs(TreeNode node){

        if(node == null) return 0;

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        int difference = leftHeight - rightHeight;
        int height = Math.max(leftHeight, rightHeight) + 1;

        if(leftHeight < 0 || rightHeight < 0 || Math.abs(difference) > 1) return -1;
        else return height;
    }
}
