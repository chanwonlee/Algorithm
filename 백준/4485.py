import heapq


def dijkstra():
    q = []
    heapq.heappush(q, (graph[0][0], 0, 0))
    distance[0][0] = 0

    while q:
        cost, x, y = heapq.heappop(q)

        if x == N - 1 and y == N - 1:
            return distance[x][y]
            break

        for dx, dy in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                current_cost = cost + graph[nx][ny]

                if current_cost < distance[nx][ny]:
                    distance[nx][ny] = current_cost
                    heapq.heappush(q, (current_cost, nx, ny))


count = 1
while True:
    N = int(input())
    if N == 0:
        break

    graph = [list(map(int, input().split())) for _ in range(N)]
    distance = [[float("inf")] * N for _ in range(N)]
    cost = dijkstra()
    print(f"Problem {count}: {cost}")
    count += 1
