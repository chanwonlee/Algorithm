N, W, L = map(int, input().split())
a = list(map(int, input().split()))

bridge = [0] * W
answer = 0
while bridge:
    answer += 1
    bridge.pop(0)
    if a:
        if sum(bridge) + a[0] <= L:
            bridge.append(a.pop(0))
        else:
            bridge.append(0)
print(answer)
