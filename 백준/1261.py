import heapq


def dijkstra():
    q = []
    heapq.heappush(q, (0, 0, 0))
    distances[0][0] = 0

    while q:
        cost, x, y = heapq.heappop(q)
        if distances[x][y] < cost:
            continue
        for dx, dy in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < N and 0 <= ny < M and distances[nx][ny] > cost + graph[nx][ny]:
                distances[nx][ny] = cost + graph[nx][ny]
                heapq.heappush(q, (distances[nx][ny], nx, ny))


M, N = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(N)]
INF = int(1e9)
distances = [[INF] * M for _ in range(N)]
dijkstra()
print(distances[N - 1][M - 1])
