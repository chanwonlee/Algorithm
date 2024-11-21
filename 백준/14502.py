from itertools import combinations
from copy import deepcopy
from collections import deque


def spread_virus(graph, virus):
    queue = deque(virus)
    while queue:
        x, y = queue.popleft()
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 0:
                graph[nx][ny] = 2
                queue.append((nx, ny))


def get_safe_area(graph):
    return sum(row.count(0) for row in graph)


N, M = map(int, input().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))
virus = [(i, j) for i in range(N) for j in range(M) if graph[i][j] == 2]
empty = [(i, j) for i in range(N) for j in range(M) if graph[i][j] == 0]

answer = 0
for walls in combinations(empty, 3):
    new_graph = deepcopy(graph)
    for x, y in walls:
        new_graph[x][y] = 1
    spread_virus(new_graph, virus)
    answer = max(answer, get_safe_area(new_graph))

print(answer)
