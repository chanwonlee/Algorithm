N = int(input())

info = {}
for _ in range(N):
    L, H = map(int, input().split())
    info[L] = H

max_L, max_H = max(info.keys()), max(info.values())
left, right, left_H, right_H = 0, max_L, 0, 0
result = 0

while True:
    if info.get(left) and left_H < info[left]:
        left_H = info[left]
    result += left_H

    if left_H == max_H:
        break

    left += 1

while True:
    if info.get(right) and right_H < info[right]:
        right_H = info[right]

    if right_H == max_H:
        break

    result += right_H
    right -= 1

result += (right - left) * max_H
print(result)
