N, K = map(int, input().split())

def solution(n, k):
    is_prime = [True] * (n + 1)
    is_prime[0] = False
    is_prime[1] = False

    cnt = 0
    for i in range(n + 1):
        if is_prime[i]:
            for j in range(i, n + 1, i):
                if not is_prime[j]:
                    continue

                is_prime[j] = False
                cnt += 1

                if cnt == K:
                    return j

print(solution(N, K))