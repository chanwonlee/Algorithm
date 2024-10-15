N = int(input())

liquids = list(map(int, input().split()))
left, right = 0, N - 1
min_sum = 2000000001
answer = ""

left_value = liquids[left]
right_value = liquids[right]

while left < right:
    if min_sum > abs(liquids[left] + liquids[right]):
        min_sum = abs(liquids[left] + liquids[right])
        left_value = liquids[left]
        right_value = liquids[right]

    if liquids[left] + liquids[right] <= 0:
        left += 1
    else:
        right -= 1

print(left_value, right_value)
