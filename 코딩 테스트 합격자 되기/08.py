def solution(s):
    stack = []
    for char in s:
        stack.append(char)
        if char == ")":
            stack.pop()
            if stack.pop() != "(":
                return False
    return len(stack) == 0