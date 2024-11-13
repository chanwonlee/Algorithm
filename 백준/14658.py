N, M, L, K = map(int, input().split())

stars = []
for _ in range(K):
    x, y = map(int, input().split())
    stars.append((x, y))
answer = 0

for x, _ in stars:
    for _, y in stars:
        count = 0
        for px, py in stars:
            if x <= px <= x + L and y <= py <= y + L:
                count += 1
        answer = max(answer, count)
print(K - answer)