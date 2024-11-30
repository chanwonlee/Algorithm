from collections import deque


def bfs():
    visited = [[False] * I for _ in range(I)]
    visited[start[0]][start[1]] = True
    q = deque()
    q.append((start[0], start[1], 0))
    while q:
        x, y, count = q.popleft()
        if x == end[0] and y == end[1]:
            return count

        for dx, dy in [(-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1), (-2, 1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < I and 0 <= ny < I and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny, count + 1))


t = int(input())

for _ in range(t):
    I = int(input())
    start = list(map(int, input().split()))
    end = list(map(int, input().split()))
    print(bfs())
