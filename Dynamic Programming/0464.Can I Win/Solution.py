class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        if maxChoosableInteger >= desiredTotal:
            return True
        if (1 + maxChoosableInteger) // 2 * maxChoosableInteger < desiredTotal:
            return False
        dp = [-1] * (1 << maxChoosableInteger)

        def dfs(target, state):
            if dp[state] != -1:
                return dp[state]
            for i in range(1, maxChoosableInteger + 1):
                idx = 1 << (i - 1)
                if idx & state == 0:
                    if target <= i or dfs(target - i, idx | state) == 0:
                        dp[state] = 1
                        return dp[state]
            dp[state] = 0
            return dp[state]

        return dfs(desiredTotal, 0) == 1