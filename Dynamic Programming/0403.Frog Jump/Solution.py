class Solution:
    def canCross(self, stones: List[int]) -> bool:
        @cache
        def dfs(pos, k):
            if pos == t:
                return True
            for i in range(-1, 2, 1):
                nx = pos + k + i
                if nx not in s:
                    continue
                if nx <= pos:
                    continue
                if dfs(nx, k + i):
                    return True
            return False

        t = stones[-1]
        s = set(stones)
        return dfs(0, 0)