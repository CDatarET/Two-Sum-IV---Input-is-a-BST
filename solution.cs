public class Solution {
    private void inorder(TreeNode root, bool[] b, Dictionary<int, int> d, int k){
        if(root == null || b[0]){
            return;
        }

        inorder(root.left, b, d, k);
        if(d.ContainsKey(k - root.val)){
            b[0] = true;
            return;
        }
        d[root.val] = 1;
        inorder(root.right, b, d, k);
    }

    public bool FindTarget(TreeNode root, int k) {
        bool[] b = {false};
        Dictionary<int, int> d = new Dictionary<int, int>();
        inorder(root, b, d, k);
        return b[0];
    }
}
