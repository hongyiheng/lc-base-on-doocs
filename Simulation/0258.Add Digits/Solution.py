class Solution:
    def addDigits(self, num: int) -> int:
        def dfs(num):
            if num < 10:
                return num
            ans = 0
            while num > 0:
                ans += num % 10
                num //= 10
            return dfs(ans)
        return dfs(num)
