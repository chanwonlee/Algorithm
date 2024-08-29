while 1:
    l1, l2, l3 = map(int, input().split())

    if l1 == 0:
        break

    max_length = max(l1, l2, l3)
    if max_length >= l1 + l2 + l3 - max_length:
        print("Invalid")
    elif l1 == l2 == l3:
        print("Equilateral")
    elif l1 == l2 or l2 == l3 or l1 == l3:
        print("Isosceles")
    elif l1 != l2 != l3:
        print("Scalene")
