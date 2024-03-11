# 내풀이
def my_solution(board, moves):
    n = len(board)
    stack = []
    answer = 0

    for move in moves:
        doll = 0
        for i in range(n):
            if board[i][move - 1] != 0:
                doll = board[i][move - 1]
                board[i][move - 1] = 0
                break

        if stack and doll != 0 and stack[-1] == doll:
            stack.pop()
            answer += 2

        elif doll != 0:
            stack.append(doll)
    return answer

# 책풀이
def solution(board, moves):
    n = len(board)
    stack = []
    answer = 0
    lanes = [[] for _ in range(n)]

    for i in range(n - 1, -1, -1):
        for j in range(n):
            if board[i][j]:
                lanes[j].append(board[i][j])

    for m in moves:
        if lanes[m - 1]:
            doll = lanes[m - 1].pop()

            if stack and stack[-1] == doll:
                stack.pop()
                answer += 2
            else:
                stack.append(doll)
    return answer