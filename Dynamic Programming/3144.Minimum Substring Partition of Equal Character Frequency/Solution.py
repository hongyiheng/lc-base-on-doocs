class Solution:
    def minimumSubstringsInPartition(self, s: str) -> int:
        @cache
        def dfs(i):
            nonlocal n
            if i >= n:
                return 0
            ans = inf
            cnt = defaultdict(int)
            mx = 0
            for j in range(i, n):
                cnt[s[j]] += 1
                mx = max(mx, cnt[s[j]])
                if j - i + 1 == mx * len(cnt):
                    ans = min(ans, dfs(j + 1) + 1)
            return ans

        n = len(s)
        return dfs(0)