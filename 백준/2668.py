def find_circle(start, n):
    if graph[n] == start:
        nums = [start]
        q = [graph[start]]

        while q:
            visit = q.pop()
            if visit == start:
                return nums
            q.append(graph[visit])
            nums.append(visit)
        return nums

    if not visited[graph[n]]:
        visited[graph[n]] = True
        return find_circle(start, graph[n])

    return []


N = int(input())
graph = [0] * (N + 1)
for i in range(1, N + 1):
    graph[i] = int(input())
answer = set()

for i in range(1, N + 1):
    visited = [False] * (N + 1)
    visited[i] = True
    if i not in answer:
        numbers = find_circle(i, graph[i])
        for number in numbers:
            answer.add(number)

print(len(answer))
for num in sorted(answer):
    print(num)
