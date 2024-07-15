class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def buildTree(preorder, inorder):
    if inorder:
        index = inorder.index(preorder.pop(0))

        node = TreeNode(inorder[index])
        node.left = buildTree(preorder, inorder[0:index])
        node.right = buildTree(preorder, inorder[index + 1:])

        return node
