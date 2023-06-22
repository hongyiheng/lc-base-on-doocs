class Solution:
    def makeSmallestPalindrome(self, s: str) -> str:
        cs = list(s)
        l, r = 0, len(s) - 1
        while l < r:
            cs[l] = cs[r] = min(cs[l], cs[r])
            l += 1
            r -= 1
        return "".join(cs)