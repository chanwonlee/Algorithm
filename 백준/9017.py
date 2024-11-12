from collections import Counter

T = int(input())

while T > 0:
    N = int(input())
    score_board = list(map(int, input().split()))
    counter = Counter(score_board)
    rank = 1
    score = {}

    for team_num in counter:
        if counter[team_num] == 6:
            score[team_num] = [0, 0, 0]

    for i in range(N):
        if score_board[i] in score:
            if score[score_board[i]][0] == 4:
                score[score_board[i]][2] = i

            if score[score_board[i]][0] < 4:
                score[score_board[i]][1] += rank

            score[score_board[i]][0] += 1
            rank += 1

    sorted_scores = sorted(score.items(), key=lambda x: (x[1][1], x[1][2]), reverse=False)
    print(sorted_scores[0][0])
    T -= 1
