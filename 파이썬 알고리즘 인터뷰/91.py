import collections


def solution(cacheSize, cities):
    elapsed = 0
    cache = collections.deque(maxlen=cacheSize)

    for c in cities:
        c = c.lower()
        print(cache)
        if c in cache:
            cache.remove(c)
            cache.append(c)
            elapsed += 1
        else:
            cache.append(c)
            elapsed += 5
    return elapsed
