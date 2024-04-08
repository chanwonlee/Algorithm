def solution(graph, source):
    num_vertices = len(graph)
    distance = [float("inf")] * num_vertices
    distance[source] = 0

    predecessor = [None] * num_vertices

    for temp in range(num_vertices - 1):
        for u in range(num_vertices):
            for v, weigh in graph[u]:
                if distance[u] + weigh < distance[v]:
                    distance[v] = distance[u] + weigh
                    predecessor[v] = u

    for u in range(num_vertices):
        for v, weigh in graph[u]:
            if distance[u] + weigh < distance[v]:
                return [-1]

    return [distance, predecessor]