from collections import deque

R, C = map(int, (input().split()))
maze_map = [list(input().strip()) for _ in range(R)]
start = ()
fire = deque()

for i in range(R):
    for j in range(C):
        if maze_map[i][j] == "J":
            start = (i, j, 0)
            maze_map[i][j] = "."
        elif maze_map[i][j] == "F":
            fire.append((i, j, 0))

fire_time = [[-1] * C for _ in range(R)]
while fire:
    x, y, time = fire.popleft()
    fire_time[x][y] = time
    for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        nx, ny = x + dx, y + dy
        if 0 <= nx < R and 0 <= ny < C and maze_map[nx][ny] == "." and fire_time[nx][ny] == -1:
            fire_time[nx][ny] = time + 1
            fire.append((nx, ny, time + 1))

q = deque([start])
visited = [[False] * C for _ in range(R)]
visited[start[0]][start[1]] = True
answer = -1

while q:
    x, y, time = q.popleft()
    if x == 0 or x == R - 1 or y == 0 or y == C - 1:
        answer = time + 1
        break

    for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        nx, ny = x + dx, y + dy
        if 0 <= nx < R and 0 <= ny < C and not visited[nx][ny] and maze_map[nx][ny] == ".":
            if fire_time[nx][ny] == -1 or fire_time[nx][ny] > time + 1:
                visited[nx][ny] = True
                q.append((nx, ny, time + 1))

if answer == -1:
    print("IMPOSSIBLE")
else:
    print(answer)
