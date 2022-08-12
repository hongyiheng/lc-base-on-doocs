class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        mx = mx_l = mx_r = 0
        for i in range(n):
            l = r = i
            while l > 0 and s[l - 1] == s[i]:
                l -= 1
            while r < n - 1 and s[r + 1] == s[i]:
                r += 1
            while l > 0 and r < n - 1 and s[l - 1] == s[r + 1]:
                l -= 1
                r += 1
            if r - l + 1 > mx:
                mx = r - l + 1
                mx_l = l
                mx_r = r
        return s[mx_l:mx_r + 1]