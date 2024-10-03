from collections import deque

n, m = map(int, input().split())
map_info = [[] * m for _ in range(n)]
result = [[-1] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]
start = (0, 0)
q = deque([])

for i in range(n):
    map_info[i] = list(map(int, input().split()))

for i in range(n):
    for j in range(m):
        if map_info[i][j] == 2:
            start = (i, j, 0)
            result[i][j] = 0
            q.append(start)
            visited[i][j] = True

        if map_info[i][j] == 0:
            result[i][j] = 0

while q:
    x, y, distance = q.popleft()
    for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        nx, ny = x + dx, y + dy
        if 0 <= nx < n and 0 <= ny < m and map_info[nx][ny] == 1 and not visited[nx][ny]:
            result[nx][ny] = distance + 1
            visited[nx][ny] = True
            q.append((nx, ny, distance + 1))

for i in range(n):
    for j in range(m):
        print(result[i][j], end=" ")
    print()
