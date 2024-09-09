N, new_score, P = map(int, input().split())

if N == 0:
    print(1)
    exit(0)

scores = list(map(int, input().split()))

if N == P and new_score <= scores[-1]:
    print(-1)
else:
    rank = 1
    for score in scores:
        if new_score < score:
            rank += 1
        else:
            break
    print(rank)
