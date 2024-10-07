from collections import deque

str = input()

count = str.count("a")

if count == 0:
    print(0)
    exit(0)

n = len(str)
q = deque(str[0: count - 1])
answer = n

for i in range(n):
    q.append(str[(i + count - 1) % n])
    answer = min(q.count("b"), answer)
    q.popleft()

print(answer)
