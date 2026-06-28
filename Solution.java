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
    private void inorder(TreeNode root, boolean[] b, HashMap<Integer, Integer> map, int k){
        if(root == null || b[0]){
            return;
        }

        inorder(root.left, b, map, k);
        if(map.containsKey(k - root.val)){
            b[0] = true;
            return;
        }
        map.put(root.val, 1);
        inorder(root.right, b, map, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        boolean[] b = {false};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        inorder(root, b, map, k);
        return b[0];
    }
}
