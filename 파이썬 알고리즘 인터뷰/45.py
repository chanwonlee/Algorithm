class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def invertTree(root):
    if root:
        root.left, root.right = invertTree(root.right), invertTree(root.left)
        return root
    return None
