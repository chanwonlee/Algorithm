N, K = map(int, input().split())

score = [list(map(int, input().split())) for _ in range(N)]
score.sort(key=lambda x: (x[1], x[2], x[3]), reverse=True)
index = [score[i][0] for i in range(N)].index(K)

for i in range(N):
    if score[i][1:] == score[index][1:]:
        print(i + 1)
        break
