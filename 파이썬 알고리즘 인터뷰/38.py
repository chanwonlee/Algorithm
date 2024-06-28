import collections


def findItinerary(tickets):
    graph = collections.defaultdict(list)
    route, stack = [], ['JFK']

    for a, b in sorted(tickets):
        graph[a].append(b)

    while stack:
        while graph[stack[-1]]:
            stack.append(graph[stack[-1]].pop(0))
        route.append(stack.pop())

    return route[::-1]
