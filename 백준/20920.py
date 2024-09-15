from collections import Counter

N, M = map(int, input().split())
voca_list = []

for _ in range(N):
    voca = input()
    if len(voca) >= M:
        voca_list.append(voca)

counter = Counter(voca_list)
sorted_voca_list = sorted(counter.keys(), key=lambda x: (-counter.get(x), -len(x), x))

for voca in sorted_voca_list:
    print(voca)
