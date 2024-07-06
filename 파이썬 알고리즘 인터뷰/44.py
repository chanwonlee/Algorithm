class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def longestUnivaluePath(root):
    global result
    result = 0

    def dfs(node):
        global result

        if node is None:
            return 0

        left = dfs(node.left)
        right = dfs(node.right)

        if node.left and node.left.val == node.val:
            left += 1
        else:
            left = 0
        if node.right and node.right.val == node.val:
            right += 1
        else:
            right = 0

        result = max(result, left + right)
        return max(left, right)

    dfs(root)
    return result
