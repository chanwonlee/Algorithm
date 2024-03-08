# 내풀이
def check(arr):
    check_stack = []
    for i in range(len(arr)):
        char = arr.pop()
        if char == ")":
            check_stack.append("(")
            continue
        if char == "}":
            check_stack.append("{")
            continue
        if char == "]":
            check_stack.append("[")
            continue

        if char == "(" or "{" or "[":
            if len(check_stack) == 0:
                return False

            if char == check_stack.pop():
                continue
            else:
                return False
    return len(check_stack) == 0

def my_solution(s):
    arr = []
    for i in s:
        arr.append(i)

    answer = 0

    for i in range(len(s) - 1):
        if check(arr.copy()):
            answer += 1
        arr.append(arr.pop(0))
    return answer

# 책풀이
def solution(s):
    answer = 0
    n = len(s)
    for i in range(n):
        stack = []
        for j in range(n):
            c = s[(i + j) % n]
            if c == "(" or c == "{" or c == "[":
                stack.append(c)
            else:
                if not stack:
                    break
                if c == ")" and stack[-1] == "(":
                    stack.pop()
                elif c == "}" and stack[-1] == "{":
                    stack.pop()
                elif c == "]" and stack[-1] == "[":
                    stack.pop()
                else:
                    break
        else:
            if not stack:
                answer += 1
    return answer