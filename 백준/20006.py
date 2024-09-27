P, M = map(int, input().split())

rooms = []

for _ in range(P):
    info = input().split()
    level, name = int(info[0]), info[1]
    join_flag = False

    if not rooms:
        rooms.append((level, [(level, name)]))
        join_flag = True

    else:
        for room in rooms:
            room_level, participants = room[0], room[1]
            if room_level - 10 <= level <= room_level + 10 and len(participants) < M:
                participants.append((level, name))
                join_flag = True
                break

    if not join_flag:
        rooms.append((level, [(level, name)]))

for room in rooms:
    participants = room[1]
    if len(participants) != M:
        print("Waiting!")
    else:
        print("Started!")

    participants.sort(key=lambda x: x[1])
    for participant in participants:
        print(participant[0], participant[1])
