T = int(input())

for _ in range(T):
    N = int(input())
    prices = list(map(int, input().split()))
    max_price = max(prices)
    max_price_count = prices.count(max_price)
    total_stock_price = 0
    current_stock_price = 0
    stock_count = 0

    for i in range(N):
        if prices[i] == max_price:
            if max_price_count == 1:
                total_stock_price += stock_count * max_price - current_stock_price
                current_stock_price = 0
                stock_count = 0
                if not i == N - 1:
                    max_price = max(prices[(i + 1):])
                    max_price_count = prices[(i + 1):].count(max_price)
            else:
                max_price_count -= 1
        else:
            stock_count += 1
            current_stock_price += prices[i]

    print(total_stock_price)
