from itertools import combinations
from collections import Counter

#내풀이
def my_solution(orders, course):
    answer = []
    for count in course:
        recommend_courses = {}
        for order in orders:
            for comb in combinations(sorted(order), count):
                if comb not in recommend_courses:
                    recommend_courses[comb] = 1
                else:
                    recommend_courses[comb] += 1
        recommend_courses = sorted(recommend_courses.items(), key=lambda x: x[1], reverse=True)
        for recommend_course in recommend_courses:
            if recommend_course[1] >= recommend_courses[0][1] and recommend_course[1] >= 2:
                answer.append(recommend_course)
    return [''.join(course) for course, _ in sorted(answer)]

# 책풀이
def solution(orders, course):
    answer = []
    for c in course:
        menu = []
        for order in orders:
            comb = combinations(sorted(order), c)
            menu += comb
            print(menu)

        counter = Counter(menu)
        if len(counter) != 0 and max(counter.values()) != 1:
            for m, cnt in counter.items():
                if cnt == max(counter.values()):
                    answer.append("".join(m))

    return sorted(answer)