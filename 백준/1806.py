N, S = map(int, input().strip().split())
nums = list(map(int, input().strip().split()))

left, right = 0, 0
sum = 0
min_length = float("INF")

while True:
    if sum >= S:
        min_length = min(min_length, right - left)
        sum -= nums[left]
        left += 1
    elif right == N:
        break
    else:
        sum += nums[right]
        right += 1

if min_length == float("INF"):
    print(0)
else:
    print(min_length)
