class Solution:
    def numberOfWays(self, s: str) -> int:
        n = len(s)
        cnt = [[0] * 2 for _ in range(n + 1)]
        for i in range(n):
            cnt[i + 1][0] = cnt[i][0]
            cnt[i + 1][1] = cnt[i][1]
            if s[i] == '0':
                cnt[i + 1][0] += 1
            else:
                cnt[i + 1][1] += 1
        ans = 0
        for i in range(n):
            if s[i] == '0':
                ans += (cnt[i][1] * (cnt[n][1] - cnt[i][1]))
            else:
                ans += (cnt[i][0] * (cnt[n][0] - cnt[i][0]))
        return ans