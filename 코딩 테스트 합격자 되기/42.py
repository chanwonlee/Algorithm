from collections import deque


def solution(maps):
    n, m = len(maps), len(maps[0])
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]

    distances = [[-1] * m for _ in range(n)]
    q = deque()
    q.append([0, 0])
    distances[0][0] = 1
    while q:
        point = q.popleft()

        for i in range(4):
            nx = point[1] + dx[i]
            ny = point[0] + dy[i]
            if 0 <= nx < m and 0 <= ny < n and maps[ny][nx] == 1 and distances[ny][nx] == -1:
                distances[ny][nx] = distances[point[0]][point[1]] + 1
                q.append([ny, nx])

    return distances[n-1][m-1]