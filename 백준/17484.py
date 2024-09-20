def go(n, m, fuel, move):
    global min_fuel
    fuel += fuel_prices[n][m]

    if fuel > min_fuel:
        return

    if n == N - 1:
        if fuel < min_fuel:
            min_fuel = fuel
        return

    for i in range(-1, 2, 1):
        if 0 <= m + i < M and move != i:
            go(n + 1, m + i, fuel, i)


N, M = map(int, input().split())
fuel_prices = [list(map(int, input().split())) for _ in range(N)]
min_fuel = 601

for i in range(M):
    go(0, i, 0, -2)

print(min_fuel)
