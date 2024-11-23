import math

T = int(input())
answer = []

for _ in range(T):
    n, m = map(int, input().split())
    answer.append(math.comb(m, n))

for a in answer:
    print(a)
