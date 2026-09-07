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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();

        if(root != null) queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int counter = 0; counter < levelSize; counter++){
                TreeNode curNode = queue.poll();

                if(curNode.left != null) queue.offer(curNode.left);
                if(curNode.right != null) queue.offer(curNode.right);

                if(counter == levelSize - 1) res.add(curNode.val);
            }
        }

        return res;
    }
}
