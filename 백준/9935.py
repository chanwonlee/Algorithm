str = input()
target = input()
answer = []

stack = []
for char in str:
    answer.append(char)
    if len(answer) >= len(target) and ''.join(answer[-len(target):]) == target:
        del answer[-len(target):]

if not answer:
    print("FRULA")
else:
    print(''.join(answer))
