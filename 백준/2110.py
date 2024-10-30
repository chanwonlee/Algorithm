N, C = map(int, input().split())
x = []
for _ in range(N):
    x.append(int(input()))
x.sort()
start, end = 1, x[-1] - x[0]
answer = 0

while start <= end:
    mid = (start + end) // 2
    distance = x[0]
    count = 1

    for i in range(1, N):
        if x[i] >= distance + mid:
            count += 1
            distance = x[i]
    if count >= C:
        start = mid + 1
        answer = mid
    else:
        end = mid - 1

print(answer)
