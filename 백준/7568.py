N = int(input())

people = [list(map(int, input().split())) for _ in range(N)]
result = []

for i in range(N):
    count = 1
    for j in range(N):
        if i != j and people[i][0] < people[j][0] and people[i][1] < people[j][1]:
            count += 1
    result.append(count)

print(' '.join(map(str, result)))
