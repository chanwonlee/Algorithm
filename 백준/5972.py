import heapq
from collections import defaultdict

N, M = map(int, input().split())

graph = defaultdict(list)
INF = 50000001
distances = [INF] * (N + 1)
distances[1] = 0

for _ in range(M):
    A_i, B_i, C_i = map(int, input().split())
    graph[A_i].append((B_i, C_i))
    graph[B_i].append((A_i, C_i))

q = []
heapq.heappush(q, (1, 0))
while q:
    current, cost = heapq.heappop(q)

    if distances[current] < cost:
        continue

    for next, distance in graph[current]:
        if distances[next] > cost + distance:
            distances[next] = cost + distance
            heapq.heappush(q, (next, cost + distance))

print(distances[N])
