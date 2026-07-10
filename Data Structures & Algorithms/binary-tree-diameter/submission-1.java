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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        
        dfs(root);
        return diameter;

    }

    public int dfs(TreeNode node){
        if(node == null) return 0;

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        int total = Math.max(leftHeight , rightHeight) + 1;

        this.diameter = Math.max(this.diameter, leftHeight + rightHeight);

        return total;
    }
}
