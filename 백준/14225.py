N = int(input())
S = list(map(int, input().split()))
S.sort()
answer = 1
for num in S:
    if num > answer:
        break
    answer += num

print(answer)
