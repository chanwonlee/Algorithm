N = int(input())
towers = list(map(int, input().split()))
last_tower_index = 0
print(0, end=" ")
stack = [(1, towers[0])]

for i in range(1, N):
    while stack:
        index, height = stack[-1]
        if towers[i] == height:
            stack.pop()
            stack.append((i + 1, towers[i]))
            print(index, end=" ")
            break

        if towers[i] < height:
            stack.append((i + 1, towers[i]))
            print(index, end=" ")
            break
        stack.pop()

    if not stack:
        print(0, end=" ")
    stack.append((i + 1, towers[i]))
