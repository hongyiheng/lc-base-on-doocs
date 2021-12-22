class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        ans, cur = 0, ""
        while len(cur) < len(b):
            cur += a
            ans += 1
        if b in cur:
            return ans
        cur += a
        ans += 1
        if b in cur:
            return ans
        return -1