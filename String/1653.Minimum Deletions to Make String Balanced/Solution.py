class Solution:
    def minimumDeletions(self, s: str) -> int:
        n = len(s)
        cnt = [[0] * 2 for _ in range(n + 1)]
        a = b = 0
        for i in range(n):
            if s[i] == 'b':
                b += 1
            cnt[i + 1][1] = b
        for i in range(n, 0, -1):
            cnt[i - 1][0] = a
            if s[i - 1] == 'a':
                a += 1
        ans = n
        for i in range(n + 1):
            ans = min(ans, cnt[i][0] + cnt[i][1])
        return ans