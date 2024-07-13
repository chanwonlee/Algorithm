class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def rangeSumBST(root, low, high):
    stack, sum = [root], 0

    while stack:
        node = stack.pop(0)
        if node:
            if node.val > low:
                stack.append(node.left)
            if node.val < high:
                stack.append(node.right)
            if low <= node.val <= high:
                sum += node.val
    return sum
