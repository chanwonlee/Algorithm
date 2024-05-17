def solution(amount):
    denominations = [100, 50, 10, 1]

    change = []

    for coin in denominations:
        while amount >= coin:
            change.append(coin)
            amount -= coin
    return change