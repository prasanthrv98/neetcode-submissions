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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        int mid = 0;

        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }

        int leftSize = mid;

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
