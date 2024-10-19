digits = [
    [1, 1, 1, 1, 1, 1, 0],  # 0
    [0, 0, 0, 0, 1, 1, 0],  # 1
    [1, 0, 1, 1, 0, 1, 1],  # 2
    [1, 0, 0, 1, 1, 1, 1],  # 3
    [0, 1, 0, 0, 1, 1, 1],  # 4
    [1, 1, 0, 1, 1, 0, 1],  # 5
    [1, 1, 1, 1, 1, 0, 1],  # 6
    [1, 0, 0, 0, 1, 1, 0],  # 7
    [1, 1, 1, 1, 1, 1, 1],  # 8
    [1, 1, 0, 1, 1, 1, 1]  # 9
]


def get_difference(digit1, digit2):
    count = 0
    for i in range(7):
        if digit1[i] != digit2[i]:
            count += 1
    return count


N, K, P, X = map(int, input().split())
answer = 0
x = str(X).zfill(K)

for i in range(1, N + 1):
    current_n = str(i).zfill(K)

    count = 0
    for j in range(len(current_n)):
        count += get_difference(digits[int(current_n[j])], digits[int(x[j])])
    if count <= P and current_n != x:
        answer += 1
print(answer)
