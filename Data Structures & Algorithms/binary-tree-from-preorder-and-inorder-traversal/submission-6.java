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

    HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i],i);
        }

        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend){

        if(prestart > preend || instart > inend) return null;

        int rootval = preorder[prestart];
        TreeNode rootNode = new TreeNode(rootval);

        int mid = inorderIndexMap.get(rootval);

        int leftSize = mid - instart;

        rootNode.left = dfs(preorder, inorder, prestart + 1, prestart+leftSize, instart, mid - 1);
        rootNode.right = dfs(preorder, inorder, prestart + leftSize + 1, preend, mid + 1, inend);

        return rootNode;

    }
}
