from collections import Counter

T = int(input())

for _ in range(T):
    W = input()
    K = int(input())
    min_len = len(W)
    max_len = 0
    counter = Counter(W)
    for word in counter:
        if counter[word] < K:
            continue

        word_index = []
        for i in range(len(W)):
            if W[i] == word:
                word_index.append(i)

        for i in range(len(word_index) - K + 1):
            min_len = min(min_len, word_index[i + K - 1] - word_index[i] + 1)
            max_len = max(max_len, word_index[i + K - 1] - word_index[i] + 1)

    if max_len == 0:
        print(-1)
    else:
        print(min_len, max_len)
