def solution(prices):
    answer = [0] * len(prices)
    stack = []
    last_index = len(prices) - 1

    for i, price in enumerate(prices):
        while stack and prices[stack[-1]] > price:
            start_index = stack.pop()
            distance = i - start_index
            answer[start_index] = distance
        stack.append(i)

    while stack:
        current_index = stack.pop()
        distance = last_index - current_index
        answer[current_index] = distance
    return answer