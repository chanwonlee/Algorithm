def is_finish(board, player):
    for i in range(0, 9, 3):
        if board[i] == player and board[i] == board[i + 1] == board[i + 2]:
            return player

    for i in range(3):
        if board[i] == player and board[i] == board[i + 3] == board[i + 6]:
            return board[i]

    if board[0] == player and board[0] == board[4] == board[8]:
        return player

    if board[2] == player and board[2] == board[4] == board[6]:
        return player

    return None


def is_valid(board):
    x_count, o_count = board.count('X'), board.count('O')
    if is_finish(board, 'X') and is_finish(board, 'O'):
        return False

    if x_count > 5 or o_count > 4:
        return False

    if x_count == o_count:
        return is_finish(board, 'O')

    if x_count == o_count + 1:
        return is_finish(board, 'X') or (is_finish(board, 'X') is None and
                                         is_finish(board, 'O') is None and
                                         "." not in board)

    return False


while True:
    str = input()
    if str == "end":
        break

    if is_valid(str):
        print("valid")
    else:
        print("invalid")
