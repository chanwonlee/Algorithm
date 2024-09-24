N, M = map(int, input().split())
keywords = set()

for _ in range(N):
    keyword = input()
    keywords.add(keyword)

for _ in range(M):
    words = input().split(",")
    for word in words:
        if word in keywords:
            keywords.remove(word)
    print(len(keywords))
