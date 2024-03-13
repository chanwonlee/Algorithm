from collections import deque


def solution(N, K):

    queue = deque(range(1, N + 1))
    while queue:
        for i in range(K - 1):
            queue.append(queue.popleft())
            answer = queue.popleft()
    return answer