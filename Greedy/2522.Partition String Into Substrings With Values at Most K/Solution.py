class Solution:
    def minimumPartition(self, s: str, k: int) -> int:
        ans, cur, n = 0, 0, len(s)
        for c in s:
            v = int(c)
            if v > k:
                return -1
            if cur * 10 + v > k:
                ans += 1
                cur = v
            else:
                cur = cur * 10 + v
        if cur:
            ans += 1
        return ans