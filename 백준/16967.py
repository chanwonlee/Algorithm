H, W, X, Y = map(int, input().split())

answer = []
graph = []

for _ in range(H + X):
    graph.append(list(map(int, input().split())))

for i in range(H):
    answer.append(graph[i][:W])

for i in range(H):
    for j in range(W):
        if i + X < H and j + Y < W:
            answer[i + X][j + Y] -= answer[i][j]

for a in answer:
    print(" ".join(map(str, a)))
