H, W = map(int, input().split())
blocks = list(map(int, input().split()))
max_index = blocks.index(max(blocks))

left, right = 0, W - 1
left_max = blocks[left]
right_max = blocks[right]
answer = 0

for block in blocks[:max_index]:
    if block > left_max:
        left_max = block
        continue
    answer += left_max - block

for block in reversed(blocks[max_index:]):
    if block > right_max:
        right_max = block
        continue
    answer += right_max - block

print(answer)
