n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]
INF = float('inf')
dp = [INF] * (k + 1)
dp[0] = 0

for coin in coins:
    for x in range(coin, k + 1):
        dp[x] = min(dp[x], dp[x - coin] + 1)

if dp[k] != INF:
    print(dp[k])
else:
    print(-1)
