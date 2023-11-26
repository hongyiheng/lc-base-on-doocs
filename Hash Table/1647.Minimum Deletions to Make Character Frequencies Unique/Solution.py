class Solution:
    def minDeletions(self, s: str) -> int:
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        ans = 0
        vis = set()
        for i, v in enumerate(cnt):
            if not v:
                continue
            while v in vis:
                v -= 1
                ans += 1
            if v:
                vis.add(v)
        return ans