import sys


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def minDiffInBST(root):
    prev = -sys.maxsize
    result = sys.maxsize

    stack = []
    node = root

    while stack or node:
        while node:
            stack.append(node)
            node = node.left

        node = stack.pop()
        result = min(result, node.val - prev)
        prev = node.val
        node = node.right

    return result
