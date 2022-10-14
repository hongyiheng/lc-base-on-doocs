class Solution:
    def distinctSubseqII(self, s: str) -> int:
        mod = int(1e9 + 7)
        tail = [0] * 26
        for c in s:
            cnt = 0
            for v in tail:
                cnt += v
            tail[ord(c) - ord('a')] = cnt % mod + 1
        ans = 0
        for v in tail:
            ans += v
        return ans % mod
