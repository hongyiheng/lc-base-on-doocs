class Solution:
    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, s: str) -> int:
        @cache
        def dfs(i, limit_low, limit_high) -> int:
            if i == n:
                return 1
            lo = int(low[i]) if limit_low and i < len(low) else 0
            hi = int(high[i]) if limit_high else 9
            res = 0
            if i < m:
                for d in range(lo, min(hi, limit) + 1):
                    res += dfs(i + 1, limit_low and d == lo, limit_high and d == hi)
            else:
                x = int(s[i - m])
                if lo <= x <= hi:
                    res = dfs(i + 1, limit_low and x == lo, limit_high and x == hi)
            return res

        low = str(start)
        high = str(finish)
        n = len(high)
        low = low.zfill(n)
        m = n - len(s)
        return dfs(0, True, True)
