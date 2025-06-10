class Solution:
    def maxDifference(self, s: str) -> int:
        cnt = [0] * 26
        for c in s:
            x = ord(c) - ord('a')
            cnt[x] += 1
        mi, mx = 110, 1
        for v in cnt:
            if not v:
                continue
            if v % 2:
                mx = max(mx, v)
            else:
                mi = min(mi, v)
        return mx - mi


