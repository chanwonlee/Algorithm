import math

N = int(input())
M = int(input())
arr = list(map(int, input().split()))

previous = arr[0]
max_len = previous - 0
for i in range(1, M, 1):
    max_len = max(max_len, math.ceil((arr[i] - previous) / 2))
    previous = arr[i]
max_len = max(max_len, N - previous)
print(max_len)
