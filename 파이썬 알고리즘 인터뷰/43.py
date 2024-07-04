class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def diameterOfBinaryTree(root):
    global longest
    longest = 0

    def dfs(node):
        global longest
        if not node:
            return -1

        left = dfs(node.left)
        right = dfs(node.right)

        longest = max(longest, left + right + 2)

        return max(left, right) + 1

    dfs(root)
    return longest
