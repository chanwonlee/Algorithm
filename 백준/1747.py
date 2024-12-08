import math


def is_palindrome(num):
    s = str(num)
    return s == s[::-1]


def is_prime(num):
    if num < 2:
        return False

    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True


N = int(input())
while True:
    if is_palindrome(N) and is_prime(N):
        print(N)
        break
    N += 1
