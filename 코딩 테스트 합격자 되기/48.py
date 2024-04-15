def solution(board):
    def find_empty():
        for i in range(9):
            for j in range(9):
                if board[i][j] == 0:
                    return i, j
        return None

    def valid(row, col, n):
        for i in range(9):
            if board[i][col] == n:
                return False

        if n in board[row]:
            return False

        box_row = (row // 3) * 3
        box_col = (col // 3) * 3

        for i in range(box_row, box_row + 3):
            for j in range(box_col, box_col + 3):
                if board[i][j] == n:
                    return False
        return True

    def sudoku():
        empty_pos = find_empty()

        if not empty_pos:
            return True

        i, j = empty_pos

        for n in range(1, 10):
            if valid(i, j, n):
                board[i][j] = n
                if sudoku():
                    return True
                board[i][j] = 0
        return False

    sudoku()
    return board