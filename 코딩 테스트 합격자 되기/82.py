def solution(d, budget):
    d.sort()
    answer = 0

    for price in d:
        if budget - price < 0:
            break
        budget -= price
        answer += 1

    return answer