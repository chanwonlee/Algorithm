import sys


def delete(q):
    if len(q) == 1:
        return 0

    value = q[1]
    q[1] = q[-1]
    q.pop()

    cursor = 1
    size = len(q) - 1
    while cursor * 2 <= size:
        left = cursor * 2
        right = cursor * 2 + 1
        smaller = left

        if right <= size and q[right] < q[left]:
            smaller = right

        if q[smaller] < q[cursor]:
            q[cursor], q[smaller] = q[smaller], q[cursor]
            cursor = smaller
        else:
            break
    return value


def insert(q, x):
    q.append(x)
    cursor = len(q) - 1
    while cursor > 1:
        if q[cursor] < q[cursor // 2]:
            q[cursor // 2], q[cursor] = q[cursor], q[cursor // 2]
        cursor //= 2


N = int(input())
q = [0]
for _ in range(N):
    x = int(sys.stdin.readline())

    if x == 0:
        print(delete(q))
    else:
        insert(q, x)
