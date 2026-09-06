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
            List<Integer> curList = new ArrayList<>();
            int levelSize = queue.size();

            for(int level = 0; level < levelSize; level++){
                TreeNode curNode = queue.pop();

                if(curNode.left != null) queue.offer(curNode.left);
                if(curNode.right != null) queue.offer(curNode.right);

                curList.add(curNode.val);
            }
           
            res.add(curList);
        }

        return res;
    }
}
