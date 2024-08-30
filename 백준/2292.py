n = int(input())
current = 1
count = 1

while n > current:
    current += 6 * count
    count += 1
print(count)
