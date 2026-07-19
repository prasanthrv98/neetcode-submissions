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
    public int goodNodes(TreeNode root) {
        
        int count  = dfs(root, root.val);

        return count;


    }

    public int dfs(TreeNode root, int max){
        int newMax = max;
        int goodNodeVal = 0;
        if(root == null) return 0;

        if(root.val >= max) {
            newMax = root.val;
            goodNodeVal = 1;
        }

        int leftGoodNodeCount = dfs(root.left, newMax);
        int rightGoodNodeCount = dfs(root.right, newMax);

        return goodNodeVal + leftGoodNodeCount + rightGoodNodeCount;
    }
}
