def solution(id_list, report, k):
    reported_user = {}
    count = {}

    for user in id_list:
        reported_user[user] = set()
        count[user] = 0

    for log in report:
        user_id, reported_id = log.split()
        reported_user[reported_id].add(user_id)

    for reported_id, user_id_list in reported_user.items():
        if len(user_id_list) >= k:
            for user_id in user_id_list:
                count[user_id] += 1

    answer = []
    for user in id_list:
        if user not in count:
            answer.append(0)
        else:
            answer.append(count[user])

    return answer
