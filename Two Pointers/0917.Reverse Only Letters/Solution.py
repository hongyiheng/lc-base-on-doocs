class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        l, r = 0, len(s) - 1
        ans = list(s)
        while l < r:
            while l < r and not str.isalpha(ans[l]):
                l += 1
            while r >= 0 and not str.isalpha(ans[r]):
                r -= 1
            if l >= r or l >= len(s) or r < 0:
                break
            ans[l], ans[r] = ans[r], ans[l]
            l += 1
            r -= 1
        return "".join(ans)