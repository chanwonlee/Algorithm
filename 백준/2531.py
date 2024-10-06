N, d, k, c = map(int, input().split())

dishes = []
answer = 0
for _ in range(N):
    dishes.append(int(input()))

for first in range(N):
    last = (first + k) % N
    if first < last:
        picked_dishes = dishes[first:last]
    else:
        picked_dishes = dishes[first:] + dishes[:last]

    count = len(set(picked_dishes))
    if c not in picked_dishes:
        count += 1

    answer = max(answer, count)

print(answer)
