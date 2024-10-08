import collections


def leastIntersval(tasks, n):
    counter = collections.Counter(tasks)
    result = 0

    while True:
        sub_count = 0
        for task, _ in counter.most_common(n + 1):
            sub_count += 1
            result += 1

            counter.subtract(task)
            counter += collections.Counter()

        if not counter:
            break

        result += n - sub_count + 1

    return result
