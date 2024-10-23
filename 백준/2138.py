def switch_bulb(bulbs, *indices):
    for index in indices:
        bulbs[index] = 1 - bulbs[index]


def go(bulbs):
    count = 0
    for i in range(1, N):
        if bulbs[i - 1] != goal_bulbs[i - 1]:
            if i == N - 1:
                switch_bulb(bulbs, i -1, i)
            else:
                switch_bulb(bulbs, i - 1, i, i + 1)
            count += 1
    return count if bulbs == goal_bulbs else INF

N = int(input())
current_bulbs = list(map(int, input()))
goal_bulbs = list(map(int, input()))
INF = 1000001

non_switch_first_bulbs = go(current_bulbs[:])
switch_bulb(current_bulbs, 0, 1)
switch_first_bulbs = go(current_bulbs) + 1

answer = min(non_switch_first_bulbs, switch_first_bulbs)

if answer == INF:
    print(-1)
else:
    print(answer)
