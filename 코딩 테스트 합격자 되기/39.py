from collections import defaultdict, deque

def solution(graph, start):
  adj_list = defaultdict(list)
  for u, v in graph:
    adj_list[u].append(v)

  def bfs(start):
    visited = set()
    queue = deque([start])
    visited.add(start)
    result.append(start)

    while queue:
      node = queue.popleft()
      for neighbor in adj_list.get(node, []):
        if neighbor not in visited:
          queue.append(neighbor)
          visited.add(neighbor)
          result.append(neighbor)

  result = []
  bfs(start)
  return result