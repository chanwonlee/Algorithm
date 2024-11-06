N = int(input())

children = []
d = [1 for _ in range(N)]

for i in range(N):
    children.append(int(input()))
    for j in range(i):
        if children[j] < children[i]:
            d[i] = max(d[i], d[j] + 1)

print(N - max(d))
