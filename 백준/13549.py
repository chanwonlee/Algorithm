from collections import deque

N, K = map(int, input().split())
min_time = abs(N - K)
visited = [min_time] * 200001
q = deque()
q.append((N, 0))

while q:

    x, time = q.popleft()

    if x >= K:
        visited[K] = min(time + (x - K), visited[K])
        continue

    if 0 < x * 2 < 2 * K and visited[x * 2] > time:
        visited[x * 2] = time
        q.appendleft((x * 2, time))

    if visited[x + 1] > time and x < K:
        visited[x + 1] = time + 1
        q.append((x + 1, time + 1))

    if visited[x - 1] > time and x > 0:
        visited[x - 1] = time + 1
        q.append((x - 1, time + 1))

print(visited[K])
