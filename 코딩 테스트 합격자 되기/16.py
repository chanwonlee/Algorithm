import math

# 내풀이
def my_solution(progresses, speeds):
    answer = []
    count = 0

    while progresses:
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
        if progresses[0] < 100:
            continue

        while progresses and progresses[0] >= 100:
            progresses.pop(0)
            speeds.pop(0)
            count += 1
        if count != 0:
            answer.append(count)
    return answer

# 책풀이
def solution(progresses, speeds):
    answer = []
    n = len(progresses)
    days_left = [math.ceil((100 - progresses[i])/ speeds[i]) for i in range(len(progresses))]

    count = 0
    max_day = days_left[0]

    for i in range(n):
        if days_left[i] <= max_day:
            count += 1
        else:
            answer.append(count)
            count = 1
            max_day = days_left[i]

    answer.append(count)
    return answer