import collections


def topKFrequent(nums, k):
    return list(zip(*collections.Counter(nums).most_common(k)))[0]