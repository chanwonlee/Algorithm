vowels = ["a", "e", "i", "o", "u"]


def validator(password):
    # 모음 여부 판별
    if not any(char in vowels for char in password):
        return False

    # 자음 혹은 모음이 연속으로 3번 있는지 판별
    count = 0
    for char in password:
        if char in vowels:
            if count > 0:
                count += 1
            else:
                count = 1
        else:
            if count < 0:
                count -= 1
            else:
                count = -1

        if abs(count) == 3:
            return False

    # 같은 단어가 연속으로 2번 있는지 판별 (ee, oo 는 제외)
    current_char = ""
    for char in password:
        if char == "e" or char == "o":
            current_char = char
            continue

        if current_char == char:
            return False

        current_char = char
    return True


while True:
    password = input()
    if password == "end":
        break
    if validator(password):
        print("<" + password + ">" " is acceptable.")
    else:
        print("<" + password + ">" " is not acceptable.")
