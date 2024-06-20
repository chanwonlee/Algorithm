import collections


def numJewelsInStones(jewels, stones):
    freqs = collections.Counter(stones)
    count = 0

    for char in jewels:
        count += freqs[char]

    return count
