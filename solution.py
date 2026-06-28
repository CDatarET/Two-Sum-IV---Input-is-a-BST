# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, root, b, d, k):
        if not root or b[0]:
            return
        
        self.inorder(root.left, b, d, k)
        if k - root.val in d:
            b[0] = True
            return
        d[root.val] = 1
        self.inorder(root.right, b, d, k)

    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        b = [False]
        d = {}
        self.inorder(root, b, d, k)
        return b[0]
