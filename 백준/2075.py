import heapq

N = int(input())
heap = []

for _ in range(N):
    if not heap:
        numbsers = list(map(int, input().split()))
        for number in numbsers:
            heapq.heappush(heap, number)
    else:
        numbsers = list(map(int, input().split()))
        for number in numbsers:
            if heap[0] < number:
                heapq.heappop(heap)
                heapq.heappush(heap, number)

print(heapq.heappop(heap))
