N = int(input())
M = int(input())
vips = []
for _ in range(M):
    vips.append(int(input()))

dp = [0] * 42
dp[0] = 1
dp[1] = 1
dp[2] = 2

for i in range(3, 41):
    dp[i] = dp[i - 1] + dp[i - 2]

answer = 1
if M > 0:
    temp = 0
    for i in range(M):
        answer *= dp[vips[i] - 1 - temp]
        temp = vips[i]
    answer *= dp[N - temp]
else:
    answer = dp[N]
print(answer)
