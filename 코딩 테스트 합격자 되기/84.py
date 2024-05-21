from collections import Counter

def solution(k, tangerine):
    counter = Counter(tangerine)

    sorted_counts = sorted(counter.values(), reverse=True)
    num_types = 0
    count_sum = 0

    for count in sorted_counts:
        count_sum += count
        num_types += 1

        if count_sum >= k:
            break

    return num_types