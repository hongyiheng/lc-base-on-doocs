class Solution:
    def countHomogenous(self, s: str) -> int:
        ans = k = 1
        for i in range(1, len(s)):
            if s[i - 1] == s[i]:
                k += 1
            else:
                k = 1
            ans += k
        return ans % int(1e9 + 7)