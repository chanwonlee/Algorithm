def solution(n):
    array = [[0] * n for I in range(n)]
    num = 1
    start_i, start_j, end_i, end_j = 0, 0, n-1, n-1

    while start_i < n and start_j < n:
        for j in range(start_j, end_j + 1):
            array[start_i][j] = num
            num += 1
        start_i += 1

        for i in range(start_i, end_i + 1):
            array[i][end_j] = num
            num += 1
        end_j -= 1

        for j in range(end_j, start_j - 1, -1):
            array[end_i][j] = num
            num += 1

        end_i -= 1

        for i in range(end_i, start_i - 1, -1):
            array[i][start_j] = num
            num += 1

        start_j += 1

    return array