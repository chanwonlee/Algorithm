def solution(lst):
    unique_list = list(set(lst))
    unique_list.sort(reverse=True)
    return unique_list