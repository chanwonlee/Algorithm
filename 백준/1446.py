N, D = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
distance = [i for i in range(D + 1)]

for i in range(D + 1):
    if i > 0:
        distance[i] = min(distance[i], distance[i - 1] + 1)

    for start, end, d in graph:
        if i == start and end <= D and distance[i] + d < distance[end]:
            distance[end] = distance[i] + d

print(distance[D])
