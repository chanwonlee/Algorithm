def transfer(A, union):
    if len(union) == 1:
        return False

    total_sum = sum(A[row][col] for row, col in union)
    average = total_sum // len(union)

    for row, col in union:
        A[row][col] = average

    return True


def dfs():
    visited = [[False] * N for _ in range(N)]
    flag = False
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                union = [(i, j)]
                q = [(i, j)]
                visited[i][j] = True

                while q:
                    r, c = q.pop()
                    for nr, nc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                        dr, dc = nr + r, nc + c
                        if 0 <= dr < N and 0 <= dc < N and not visited[dr][dc] and L <= abs(A[r][c] - A[dr][dc]) <= R:
                            q.append((dr, dc))
                            union.append((dr, dc))
                            visited[dr][dc] = True
                if transfer(A, union):
                    flag = True
    return flag


N, L, R = map(int, input().split())
A = [[] * N for _ in range(N)]
answer = 0
for i in range(N):
    A[i] = list(map(int, input().split()))

while True:
    if dfs():
        answer += 1
    else:
        break

print(answer)
