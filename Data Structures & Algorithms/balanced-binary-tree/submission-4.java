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
       int res[] = dfs(root);

       boolean isBalanced = res[1] == 1;

       return isBalanced;
    }

   public int[] dfs(TreeNode root){
        if(root == null) return new int[]{0, 1};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int nodeHeight = Math.max(left[0], right[0]) + 1;

        boolean isBalanced = (left[1] == 1 && right[1] == 1) && 
                             (Math.abs(left[0] - right[0]) <= 1);

        return new int[] {nodeHeight, isBalanced ? 1 : 0};

    }
}
