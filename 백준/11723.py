import sys

s = set()
n = int(sys.stdin.readline())
for i in range(n):
    command = sys.stdin.readline().split()
    if len(command) == 1:
        if command[0] == 'all':
            s = set([x for x in range(1, 21)])
        if command[0] == 'empty':
            s = set()

    else:
        action, x = command[0], int(command[1])

        if action == 'add':
            s.add(x)

        elif action == 'check':
            if x in s:
                print(1)
            else:
                print(0)

        elif action == 'remove':
            if x in s:
                s.discard(x)

        elif action == 'toggle':
            if x in s:
                s.discard(x)
            else:
                s.add(x)
