def solution(s):
    zero_count = 0
    transform_count = 0

    while s != "1":
        transform_count += 1
        zero_count += s.count("0")
        s = bin(s.count("1"))[2:]

    return [transform_count, zero_count]