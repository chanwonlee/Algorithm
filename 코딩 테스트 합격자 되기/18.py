def solution(arr, target):
    hash_map = [False] * (target + 1)

    for num in arr:
        if num <= target:
            hash_map[num] = True

    for num in arr:
        complement = target - num
        if (
                hash_map[complement]
                and num != complement
                and 0 <= complement <= target
        ):
            return True
    return False