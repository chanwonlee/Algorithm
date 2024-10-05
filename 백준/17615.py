N = int(input())
balls = input()
print(min(balls.lstrip(balls[0]).count(balls[0]), N - balls.count(balls[0]),
          balls.rstrip(balls[-1]).count(balls[-1]), N - balls.count(balls[-1])))
