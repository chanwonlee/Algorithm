def solution(decimal):
    stack = []
    while decimal > 0:
        stack.append(decimal % 2)
        decimal //= 2

    stack.reverse()
    return ''.join(map(str, stack))
