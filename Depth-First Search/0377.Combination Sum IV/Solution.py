class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        memo = [-1] * 1001

        def dfs(t):
            if t == 0:
                return 1
            if t < 0:
                return 0
            if memo[t] != -1:
                return memo[t]
            ans = 0
            for num in nums:
                ans += dfs(t - num)
            memo[t] = ans
            return ans

        return dfs(target)
