class Solution:
    def minimumDeletions(self, s: str) -> int:
        a = sum(1 if c == 'a' else 0 for c in list(s))
        b = 0
        n = len(s)
        ans = a
        for c in s:
            if c == 'a':
                a -= 1
            else:
                b += 1
            ans = min(ans, a + b)
        return ans

