N = input()

answer = 0
while N:
    answer += 1
    num = str(answer)
    while num and N:
        if N[0] == num[0]:
            N = N[1:]
        num = num[1:]

print(answer)
