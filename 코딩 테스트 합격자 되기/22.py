def solution(record):
    uid = {}
    for logs in record:
        log = logs.split(" ")
        if log[0] != "Leave":
            uid[log[1]] = log[2]

    answer = []
    for logs in record:
        log = logs.split(" ")
        if log[0] == "Enter":
            answer.append("%s님이 들어왔습니다." % uid[log[1]])
        if log[0] == "Leave":
            answer.append("%s님이 나갔습니다." % uid[log[1]])

    return answer