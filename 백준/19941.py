N, K = map(int, input().split())
str = list(input())
answer = 0

for i in range(N):
    if str[i] == 'P':
        for i in range(max(i - K, 0), min(i + K + 1, N)):
            if str[i] == 'H':
                str[i] = 0
                answer += 1
                break

print(answer)
