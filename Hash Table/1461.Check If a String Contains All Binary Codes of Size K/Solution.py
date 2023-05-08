class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        cnt = set()
        cur = w = 0
        for i in range(len(s)):
            cur = (cur << 1) + int(s[i])
            w += 1
            if w >= k:
                cnt.add(cur)
                cur -= int(s[i - k + 1]) << (k - 1)
                w -= 1
        return len(cnt) == (1 << k)
