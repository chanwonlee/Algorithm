import collections


def groupAnagrams(strs):
    anagrams = collections.defaultdict(list)

    for word in strs:
        anagrams[''.join(sorted(word))].append(word)
    return anagrams.values()
