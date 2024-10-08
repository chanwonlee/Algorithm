def go(str):
    if str == S:
        return 1

    if len(str) < len(S):
        return 0

    if str[-1] == "A":
        if go(str[:-1]):
            return 1

    if str[0] == "B":
        str = str[::-1]
        if go(str[:-1]):
            return 1

    return 0


S = input()
T = input()
print(go(T))
