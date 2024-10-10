from collections import deque

N, M = map(int, input().split())
graph = [0] * 101
shortcuts = {}

for _ in range(N + M):
    start, end = map(int, input().split())
    shortcuts[start] = end

q = deque([])
q.append(1)

while q:
    start = q.popleft()
    if start == 100:
        break

    for i in range(1, 7, 1):
        current = start + i
        if shortcuts.get(current):
            current = shortcuts.get(current)
        if current < 101 and graph[current] == 0:
            graph[current] = graph[start] + 1
            q.append(current)

print(graph[100])
