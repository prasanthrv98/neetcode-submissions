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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot == null) return true;
        if (root == null) return false;

        boolean isRootSame = isSameTree(root, subRoot);
        boolean isLeftSubtreeSame = isSubtree(root.left, subRoot);
        boolean isRightSubtreeSame = isSubtree(root.right, subRoot);

        return isRootSame || isLeftSubtreeSame || isRightSubtreeSame;
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;

        boolean currentNodeVal = p.val == q.val;

        boolean isLeftTreeSame = isSameTree(p.left, q.left);
        boolean isRightTreeSame = isSameTree(p.right, q.right);

        return currentNodeVal && isLeftTreeSame && isRightTreeSame;
    }
}
