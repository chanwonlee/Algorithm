N, M = list(map(int, input().split()))
A = []

for _ in range(N):
    A.append(int(input()))

left, right = 0, 0
result = float("INF")
A.sort()

while left <= right < N:
    if A[right] - A[left] < M:
        right += 1

    else:
        result = min(result, A[right] - A[left])
        left += 1

print(result)
