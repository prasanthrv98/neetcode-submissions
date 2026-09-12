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

public class Codec {

    int index = 0;
    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    public void dfs(TreeNode node){
        if(node == null) {
            sb.append("null");
            sb.append(",");
            return;
        }

  
        sb.append(node.val);
        sb.append(",");
        dfs(node.left);
        dfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        index = 0;
        return buildTree(tokens);
    }

    public TreeNode buildTree(String[] tokens){
        String val = tokens[index];

        if(val.equals("null")) {
            index++;
            return null;
            }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        index++;
        root.left = buildTree(tokens);
        root.right = buildTree(tokens);

        return root;

    }
}
