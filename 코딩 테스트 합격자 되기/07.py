def is_valid_move(x, y):
    if x < 0 or x > 10 or y < 0 or y > 10:
        return False
    return True

def move(x, y, dir):
    if dir == "U":
        nx, ny = x, y - 1
    if dir == "R":
        nx, ny = x + 1, y
    if dir == "D":
        nx, ny = x, y + 1
    if dir == "L":
        nx, ny = x - 1, y
    return nx, ny

def solution(dirs):
    x, y = 5, 5
    visited = set()

    for dir in dirs:
        nx, ny = move(x, y, dir)
        if not is_valid_move(nx, ny):
            continue

        visited.add((x,y,nx,ny))
        visited.add((nx,ny,x,y))
        x, y = nx, ny
    return len(visited) / 2