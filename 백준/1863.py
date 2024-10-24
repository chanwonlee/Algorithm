N = int(input())
stack = []
answer = 0

for i in range(N):
    _, height = map(int, input().split())

    if not stack:
        if height == 0:
            continue
        answer += 1
        stack.append(height)
        continue

    if height > stack[-1]:
        answer += 1
        stack.append(height)
    else:
        while stack:
            stack.pop()
            if not stack:
                if height == 0:
                    break
                stack.append(height)
                answer += 1
                break
            if stack[-1] < height:
                stack.append(height)
                answer += 1
                break
            if stack[-1] == height:
                break
print(answer)
