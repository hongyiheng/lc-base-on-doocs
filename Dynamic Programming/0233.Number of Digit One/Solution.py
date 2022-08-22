class Solution:
    def countDigitOne(self, n: int) -> int:
        s = list(str(n))

        def dfs(cur, cnt, limit):
            if cur == m:
                return cnt
            if not limit and dp[cur][cnt] >= 0:
                return dp[cur][cnt]
            ans = 0
            up = int(s[cur]) if limit else 9
            for i in range(up + 1):
                next_cnt = cnt
                next_cnt += 1 if i == 1 else 0
                ans += dfs(cur + 1, next_cnt, limit and i == up)
            if not limit:
                dp[cur][cnt] = ans
            return ans

        m = len(s)
        dp = [[-1] * m for _ in range(m)]
        return dfs(0, 0, True)