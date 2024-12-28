import heapq

N, M = map(int, input().split())
a = list(map(int, input().split()))

heapq.heapify(a)
for _ in range(M):
    a1 = heapq.heappop(a)
    a2 = heapq.heappop(a)

    heapq.heappush(a, a1 + a2)
    heapq.heappush(a, a1 + a2)

print(sum(a))
