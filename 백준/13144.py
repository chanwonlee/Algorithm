N = int(input())
l = list(map(int, input().split()))
answer = 0
number = [False] * 100001
start, end = 0, 0
while start < N and end < N:
    if not number[l[end]]:
        number[l[end]] = True
        end += 1
        answer += end - start
    else:
        while number[l[end]]:
            number[l[start]] = False
            start += 1
print(answer)
