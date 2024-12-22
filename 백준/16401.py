M, N = map(int, input().split())
L = list(map(int, input().split()))
left, right = 1, max(L)
answer = 0

while left <= right:
    mid = (left + right) // 2
    count = sum(l // mid for l in L)

    if count >= M:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)
