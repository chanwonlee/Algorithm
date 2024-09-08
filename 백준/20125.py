N = int(input())

board = [input() for _ in range(N)]
heart = ()

# 머리 찾기
for i in range(N):
    for j in range(N):
        if board[i][j] == '*':
            heart = (i + 1, j)
            break
    if heart:
        break
print(heart[0] + 1, heart[1] + 1)

# 왼쪽 팔 찾기
left_arm_length = 0
for i in range(heart[1] - 1, -1, -1):
    if board[heart[0]][i] == "_":
        break
    left_arm_length += 1
print(left_arm_length, end=" ")

# 오른쪽 팔 찾기
right_arm_length = 0
for i in range(heart[1] + 1, N, 1):
    if board[heart[0]][i] == "_":
        break
    right_arm_length += 1
print(right_arm_length, end=" ")

# 허리 찾기
waist_length = 0
for i in range(heart[0] + 1, N, 1):
    if board[i][heart[1]] == "_":
        break
    waist_length += 1
print(waist_length, end=" ")

# 왼쪽 다리 찾기
left_leg_length = 0
for i in range(heart[0] + waist_length + 1, N, 1):
    if board[i][heart[1] - 1] == "_":
        break
    left_leg_length += 1
print(left_leg_length, end=" ")

# 오른쪽 다리 찾기
right_leg_length = 0
for i in range(heart[0] + waist_length + 1, N, 1):
    if board[i][heart[1] + 1] == "_":
        break
    right_leg_length += 1
print(right_leg_length, end=" ")
