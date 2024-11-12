import heapq


def dijkstra(start, graph):
    q = []
    distances = [INF] * (N + 1)

    heapq.heappush(q, (start, 0))
    distances[start] = 0

    while q:
        current, cost = heapq.heappop(q)
        if distances[current] < cost:
            continue
        for next, distance in graph[current]:
            if distances[next] > cost + distance:
                distances[next] = cost + distance
                heapq.heappush(q, (next, cost + distance))
    return distances


N, M, X = map(int, input().split())
graph = [[] for _ in range(N + 1)]
reverse_graph = [[] for _ in range(N + 1)]

INF = int(1e9)

for _ in range(M):
    a, b, T = map(int, input().split())
    graph[a].append((b, T))
    reverse_graph[b].append((a, T))

result = 0
foward = dijkstra(X, graph)
back = dijkstra(X, reverse_graph)

for i in range(1, N + 1):
    result = max(result, foward[i] + back[i])

print(result)
