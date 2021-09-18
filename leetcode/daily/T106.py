class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.root = val
        self.left = left
        self.right = right


class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if len(inorder) == 0:
            return None
        if len(inorder) == 1:
            return TreeNode(inorder[-1])
        post = postorder[-1]
        subscript = inorder.index(post)

        root = TreeNode(post)
        root.left = self.buildTree(inorder[:subscript], postorder[:subscript])
        root.right = self.buildTree(inorder[subscript + 1:], postorder[subscript:-1])

        return root