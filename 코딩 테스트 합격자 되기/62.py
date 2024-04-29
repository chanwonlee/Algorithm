def solution(arr, n):
    def rotate_90(arr):
        n = len(arr)
        copy_array = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                copy_array[j][n - i - 1] = arr[i][j]
        return copy_array

    for _ in range(n):
        arr = rotate_90(arr)

    return arr