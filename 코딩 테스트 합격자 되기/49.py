def solution(k, dungeons):
    def go(k, visited, cnt):
        answer = cnt
        for i in range(len(dungeons)):
            if visited[i] == 0 and k >= dungeons[i][0]:
                visited[i] = 1
                answer = max(answer, go(k - dungeons[i][1], visited, cnt + 1))
                visited[i] = 0
        return answer

    visited = [0] * len(dungeons)
    return go(k, visited, 0)