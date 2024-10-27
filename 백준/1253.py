N = int(input())
A = list(map(int, input().split()))
A.sort()
answer = 0
for i in range(len(A)):
    left = 0
    right = len(A) - 1

    while left < right:
        if left == i:
            left += 1
            continue

        if right == i:
            right -= 1
            continue

        two_sum = A[left] + A[right]

        if two_sum == A[i]:
            answer += 1
            break

        if two_sum > A[i]:
            right -= 1

        if two_sum < A[i]:
            left += 1

print(answer)
