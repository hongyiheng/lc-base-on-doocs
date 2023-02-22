class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        tail = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            tail[i] += tail[i + 1] + piles[i]

        @cache
        def dfs(i: int, m: int) -> int:
            if i + m * 2 >= n:
                return tail[i]
            t = 0x3f3f3f3f3f
            for x in range(1, m * 2 + 1):
                t = min(dfs(i + x, max(m, x)), t)
            return tail[i] - t

        return dfs(0, 1)
