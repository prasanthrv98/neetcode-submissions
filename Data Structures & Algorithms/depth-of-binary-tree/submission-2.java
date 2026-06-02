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

        if(root == null) return 0;
        
        int level = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            for (TreeNode node: queue){
               TreeNode currentNode = queue.poll();
               if(currentNode.left != null) queue.offer(currentNode.left);
               if(currentNode.right != null) queue.offer(currentNode.right);

            }
            level += 1; 
        }


        return level;
    }
}
