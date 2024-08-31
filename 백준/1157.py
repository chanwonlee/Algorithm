from collections import Counter

counter = Counter(input().upper()).most_common()

if len(counter) == 1 or counter[0][1] > counter[1][1]:
    print(counter[0][0])
else:
    print("?")
