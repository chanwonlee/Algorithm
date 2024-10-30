dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def dfs(x, y, count):
    global answer
    if check[board[x][y]]:
        answer = max(answer, count)
        return
    check[board[x][y]] = True
    for k in range(4):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx < R and 0 <= ny < C:
            dfs(nx, ny, count + 1)
    check[board[x][y]] = False


R, C = map(int, input().split())
board = [list(map(lambda ch: ord(ch) - ord('A'), input())) for _ in range(R)]
check = [False] * 26
answer = 1

dfs(0, 0, 0)
print(answer)
