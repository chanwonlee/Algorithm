def dfs(step, idx):
    global result
    if step == N // 2:
        x = 0
        y = 0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:
                    x += S[i][j]
                elif not visited[i] and not visited[j]:
                    y += S[i][j]
        result = min(result, abs(x - y))
        return

    for i in range(idx, N):
        if not visited[i]:
            visited[i] = True
            dfs(step + 1, i + 1)
            visited[i] = False


N = int(input())
S = []
for _ in range(N):
    S.append(list(map(int, input().split())))

result = int(1e9)
visited = [False] * N
dfs(0, 0)
print(result)
