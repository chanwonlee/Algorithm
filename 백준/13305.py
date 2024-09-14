N = int(input())
distances = list(map(int, input().split()))
gax_prices = list(map(int, input().split()))

total_price = 0
min_gax_price = gax_prices[0]

for i in range(N - 1):
    if min_gax_price > gax_prices[i]:
        min_gax_price = gax_prices[i]
    total_price += min_gax_price * distances[i]

print(total_price)
