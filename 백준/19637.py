N, M = map(int, input().split())
titles = []
powers = []

for _ in range(N):
    titles.append(input().split())

for _ in range(M):
    powers.append(int(input()))

for power in powers:
    left, right = 0, N
    result = 0

    while left <= right:
        mid = (left + right) // 2
        if int(titles[mid][1]) >= power:
            result = mid
            right = mid - 1
        else:
            left = mid + 1

    print(titles[result][0])
