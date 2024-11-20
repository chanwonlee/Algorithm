N = int(input())
words = [(input().strip(), i) for i in range(N)]
words.sort()
prefix = ''
answer_min_idx = float('inf')

for i in range(N - 1):
    word1, idx1 = words[i]
    word2, idx2 = words[i + 1]

    if word1 == word2:
        continue

    maxlen = min(len(word1), len(word2))
    j = 0
    while j < maxlen and word1[j] == word2[j]:
        j += 1

    if j > len(prefix) or (j == len(prefix) and min(idx1, idx2) < answer_min_idx):
        prefix = word1[:j]
        answer_min_idx = min(idx1, idx2)

answer = list()
for word, idx in words:
    if word[:len(prefix)] == prefix:
        answer.append((word, idx))
answer.sort(key=lambda x: x[1])

for word in answer[:2]:
    print(word[0])
