class Solution:
    def numberOfWays(self, startPos: int, endPos: int, k: int) -> int:
        mod = int(1e9 + 7)

        @cache
        def dfs(cur, left):
            nonlocal endPos
            if abs(cur - endPos) > left:
                return 0
            if left == 0:
                return 1
            return (dfs(cur - 1, left - 1) + dfs(cur + 1, left - 1)) % mod

        return dfs(startPos, k)