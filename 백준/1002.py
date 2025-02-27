from math import sqrt

T = int(input())

def solution():
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    dist = sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)
    diff = abs(r1 - r2)

    if dist == 0 and r1 == r2:
        return -1

    if dist == r1 + r2 or dist == diff:
        return 1

    if diff < dist < r1 + r2:
        return 2

    return 0

for _ in range(T):
    print(solution())