N = int(input())
channels = []
for _ in range(N):
    channels.append(input())
kbs1_idx = channels.index("KBS1")
kbs2_idx = channels.index("KBS2")

if kbs1_idx > kbs2_idx:
    kbs2_idx += 1

print('1' * kbs1_idx + '4' * kbs1_idx + '1' * kbs2_idx + '4' * (kbs2_idx - 1))
