def check_condition(x, y, sign):
    if sign == '<':
        return x < y
    else:
        return x > y


def solve(depth, s):
    global max_ans, min_ans
    if depth == n + 1:
        if len(min_ans) == 0:
            min_ans = s
        else:
            max_ans = s
        return

    for i in range(10):
        if not visited[i]:
            if depth == 0 or check_condition(s[-1], str(i), sign[depth - 1]):
                visited[i] = True
                solve(depth + 1, s + str(i))
                visited[i] = False


n = int(input())
sign = list(input().split())
min_ans = ""
max_ans = ""
visited = [0] * 10
solve(0, "")
print(max_ans)
print(min_ans)
