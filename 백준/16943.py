from itertools import permutations

A, B = map(int, input().split())
C = -1
numers = []
for item in permutations(str(A)):
    numers.append(''.join(item))

for number in numers:
    if number.startswith("0"):
        continue
    if int(number) < B:
        C = max(C, int(number))

print(C)
