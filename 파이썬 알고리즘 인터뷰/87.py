def climbStairs(n):
    dp = {}

    def climb(i):
        if i <= 2:
            return i
        if i in dp:
            return dp[i]
        dp[i] = climb(i - 1) + climb(i - 2)
        return dp[i]

    return climb(n)
