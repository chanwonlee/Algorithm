N = int(input())
target_word = list(input())
answer = 0

for _ in range(N - 1):
    compare = target_word[:]
    word = input()
    cnt = 0

    for char in word:
        if char in compare:
            compare.remove(char)
        else:
            cnt += 1

    if cnt < 2 and len(compare) < 2:
        answer += 1

print(answer)
