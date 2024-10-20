import re


def calculator(str):
    op = re.split('([-+])', str)
    sum = int(op[0])
    for i in range(1, len(op), 2):
        if op[i] == "+":
            sum += int(op[i + 1])
        else:
            sum -= int(op[i + 1])
    return sum


def go(str, n):
    if n == N:
        if calculator(str.replace(" ", "")) == 0:
            print(str)
            return str
        else:
            return None

    go(f"{str} {n + 1}", n + 1)
    go(f"{str}+{n + 1}", n + 1)
    go(f"{str}-{n + 1}", n + 1)


T = int(input())
for _ in range(T):
    N = int(input())
    go("1", 1)
    print()
