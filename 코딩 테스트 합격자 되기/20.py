def solution(participant, completion):
    hash_map = {}

    for name in participant:
        if name in hash_map:
            hash_map[name] += 1
        else:
            hash_map[name] = 1

    for name in completion:
        if hash_map[name] > 0:
            hash_map[name] -= 1

    for name, count in hash_map.items():
        if count > 0:
            return name