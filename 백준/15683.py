from copy import deepcopy

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

cctv_directions = {
    1: [[0], [1], [2], [3]],
    2: [[0, 1], [2, 3]],
    3: [[0, 3], [3, 1], [1, 2], [2, 0]],
    4: [[0, 2, 3], [0, 1, 3], [1, 2, 3], [0, 1, 2]],
    5: [[0, 1, 2, 3]],
}


def mark_area(graph, i, j, directions_set):
    for d in directions_set:
        x, y = i, j
        while True:
            nx, ny = x + directions[d][0], y + directions[d][1]
            if not (0 <= nx < len(graph) and 0 <= ny < len(graph[0])):
                break
            if graph[nx][ny] == 6:
                break
            if graph[nx][ny] == 0:
                graph[nx][ny] = 7
            x, y = nx, ny


def bfs(graph, step, cctvs, answer):
    if step == len(cctvs):
        return min(answer, sum(row.count(0) for row in graph))

    i, j, cctv_type = cctvs[step]
    for directions_set in cctv_directions[cctv_type]:
        copy_graph = deepcopy(graph)
        mark_area(copy_graph, i, j, directions_set)
        answer = bfs(copy_graph, step + 1, cctvs, answer)

    return answer


N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
cctvs = [(i, j, graph[i][j]) for i in range(N) for j in range(M) if 1 <= graph[i][j] <= 5]
answer = N * M
answer = bfs(graph, 0, cctvs, answer)
print(answer)
