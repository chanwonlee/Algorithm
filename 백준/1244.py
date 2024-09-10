N = int(input())
switches = [-1] + list(map(int, input().split()))
count = int(input())


def switch(n):
    if switches[n] == 0:
        switches[n] = 1
    else:
        switches[n] = 0


for _ in range(count):
    student, num = map(int, input().split())
    if student == 1:
        for j in range(num, N+1, num):
            switch(j)

    elif student == 2:
        if num >= 1:
            left, right = num - 1, num + 1
            switch(num)
            while left >= 1 and right < N + 1:
                if switches[left] == switches[right]:
                    switch(left)
                    switch(right)
                    left -= 1
                    right += 1
                else:
                    break

for i in range(1, N + 1):
    print(switches[i], end=" ")
    if i % 20 == 0:
        print()
