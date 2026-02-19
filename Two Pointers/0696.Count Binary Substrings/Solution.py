class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        cnt = [0] * 2
        cur = -1
        ans = 0
        for c in list(s):
            v = ord(c) - ord('0')
            if cur != v:
                cnt[v] = 0
            cur = v
            cnt[v] += 1
            if cnt[v ^ 1] >= cnt[v]:
                ans += 1
        return ans