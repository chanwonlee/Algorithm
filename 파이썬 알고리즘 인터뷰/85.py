def fib(n):
    x, y = 0, 1
    for i in range(0, n):
        x, y = y, x + y
    return x
