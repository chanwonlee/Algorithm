N, X = map(int, input().split())
views = list(map(int, input().split()))
max_views = 0
current_views = sum(views[:X - 1])
count = 0

for i in range(N - X + 1):
    current_views += views[i + X - 1]

    if current_views == max_views:
        count += 1
    elif current_views > max_views:
        count = 1
        max_views = current_views

    current_views -= views[i]

if max_views == 0:
    print("SAD")
else:
    print(max_views)
    print(count)
