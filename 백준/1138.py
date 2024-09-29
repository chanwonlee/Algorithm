N = int(input())
people = list(map(int, input().split()))
result = [0] * N

for i in range(N):
    count = 0
    for j in range(N):
        if count == people[i] and result[j] == 0:
            result[j] = i + 1
            break
        elif result[j] == 0:
            count += 1

print(' '.join(map(str, result)))
