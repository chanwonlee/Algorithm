N, K = map(int, input().split())
S = list(map(int, input().split()))

end = 0
answer = 0
current_k = 0
odd = 0

for start in range(N):
    while odd <= K and end < N:
        if S[end] % 2 == 1:
            odd += 1
        else:
            current_k += 1
        end += 1

        if start == 0 and end == N:
            answer = current_k
            break

    if odd == K + 1:
        answer = max(current_k, answer)
    if S[start] % 2 == 1:
        odd -= 1
    else:
        current_k -= 1
print(answer)
