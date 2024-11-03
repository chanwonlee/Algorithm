from collections import deque

N = int(input())
M = int(input())
graph = [[] for _ in range(N)]
connected_city = [set() for _ in range(N)]

for i in range(N):
    info = list(map(int, input().split()))
    for j in range(N):
        if info[j] == 1:
            graph[i].append(j)

for i in range(N):
    visited = [False] * N
    q = deque([i])
    while q:
        current = q.popleft()
        if visited[current]:
            continue
        visited[current] = True
        connected_city[i].add(current)
        for next_city in graph[current]:
            if not visited[next_city]:
                q.append(next_city)

plan = list(map(int, input().split()))
is_possible = True
for i in range(M - 1):
    start = plan[i] - 1
    end = plan[i + 1] - 1
    if end not in connected_city[start]:
        is_possible = False
        break

print("YES" if is_possible else "NO")
