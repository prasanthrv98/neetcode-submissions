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
    public int maxDepth(TreeNode root) {
        int leftMax = 1;
        int rightMax = 1;
        if(root == null) return 0;


         leftMax += maxDepth(root.left);
         rightMax += maxDepth(root.right);

        return Math.max(leftMax, rightMax);
    }
}
