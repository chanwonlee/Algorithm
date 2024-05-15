def solution(board):
    row, col = len(board), len(board[0])

    for i in range(1, row):
        for j in range(1, col):
            if board[i][j] == 1:
                up, left, up_left = (
                    board[i - 1][j],
                    board[i][j - 1],
                    board[i - 1][j - 1]
                )
                board[i][j] = min(up, left, up_left) + 1

    max_val = max(max(row) for row in board)
    return max_val ** 2