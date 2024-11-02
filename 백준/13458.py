N = int(input())
A = list(map(int, input().split()))
B, C = map(int, input().split())
answer = 0

for i in range(N):
    A[i] -= B
    answer += 1
    if A[i] > 0:
        if A[i] % C == 0:
            answer += A[i] // C
        else:
            answer += A[i] // C + 1

print(answer)
