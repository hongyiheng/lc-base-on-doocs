class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        def check(l, r):
            a, b, c = cnt[r][0] - cnt[l][0], cnt[r][1] - cnt[l][1], cnt[r][2] - cnt[l][2]
            return min(ma - a, mb - b, mc - c) >= k

        n = len(s)
        cnt = [[0] * 3 for _ in range(n + 1)]
        for i in range(n):
            cnt[i + 1] = cnt[i][::]
            cnt[i + 1][ord(s[i]) - ord('a')] += 1
        ma, mb, mc = cnt[n]
        if min(ma, mb, mc) < k:
            return -1
        ans = inf
        l = r = 0
        while r < n + 1:
            while r < n + 1 and check(l, r):
                ans = min(ans, n - (r - l))
                r += 1
            while l < r < n + 1 and not check(l, r):
                l += 1
            r += 1
        return ans