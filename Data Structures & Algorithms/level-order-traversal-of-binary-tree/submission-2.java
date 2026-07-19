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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root != null) queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);

                if(curNode.left != null) queue.offer(curNode.left);
                if(curNode.right != null) queue.offer(curNode.right);

            }
            res.add(curLevel);
        }

        return res;
        
    }
}
