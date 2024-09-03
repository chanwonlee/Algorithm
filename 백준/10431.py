P = int(input())

for _ in range(P):
    stream = input().split()
    T, students = int(stream[0]), list(map(int, stream[1:]))
    sorted_students = []
    answer = 0

    for height in students:
        print(sorted_students)
        insert_position = len(sorted_students)
        for i in range(len(sorted_students)):
            if sorted_students[i] > height:
                insert_position = i
                break

        answer += len(sorted_students) - insert_position
        sorted_students.insert(insert_position, height)

    print(T, answer)
