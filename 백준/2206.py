from collections import deque

N, M = map(int, input().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input())))

visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]
visited[0][0][0] = 1
q = deque()
q.append((0, 0, 0))
answer = -1
while q:
    x, y, c = q.popleft()

    if x == N - 1 and y == M - 1:
        answer = visited[x][y][c]
        break

    for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        nx, ny = x + dx, y + dy
        if 0 <= nx < N and 0 <= ny < M:
            if graph[nx][ny] == 1 and c == 0:
                visited[nx][ny][1] = visited[x][y][0] + 1
                q.append((nx, ny, 1))

            if graph[nx][ny] == 0 and visited[nx][ny][c] == 0:
                visited[nx][ny][c] = visited[x][y][c] + 1
                q.append((nx, ny, c))

print(answer)
