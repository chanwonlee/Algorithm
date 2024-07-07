class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def mergeTrees(root1, root2):
    if root1 and root2:
        node = TreeNode(root1.val + root2.val)
        node.left = mergeTrees(root1.left, root2.left)
        node.right = mergeTrees(root1.right, root2.right)

        return node
    else:
        return root1 or root2
