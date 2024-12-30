n, k = map(int, input().split())
result = []
stack = [(0, [])]

while stack:
    sum, expression = stack.pop()
    if sum == n:
        result.append('+'.join(map(str, expression)))
        continue
    if sum > n:
        continue
    for num in range(3, 0, -1):
        stack.append((sum + num, expression + [num]))

result.sort()
if k > len(result):
    print(-1)
else:
    print(result[k - 1])
