from collections import deque

N, K = map(int, input().split())
max_pos = 100000
visited = [-1] * (max_pos + 1)
q = deque()
q.append((N, 0))
visited[N] = N

while q:
    x, time = q.popleft()

    if x == K:
        path = []
        while x != N:
            path.append(x)
            x = visited[x]
        path.append(N)
        print(time)
        print(" ".join(map(str, path[::-1])))
        break

    for nx in (x - 1, x + 1, x * 2):
        if 0 <= nx <= max_pos and visited[nx] == -1:
            visited[nx] = x
            q.append((nx, time + 1))
