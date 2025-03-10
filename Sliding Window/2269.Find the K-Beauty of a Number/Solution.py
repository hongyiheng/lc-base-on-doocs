class Solution:
    def divisorSubstrings(self, num: int, k: int) -> int:
        s = str(num)
        l = ans = 0
        for r in range(len(s)):
            if r - l + 1 == k:
                v = int(s[l:r + 1])
                if v and num % v == 0:
                    ans += 1
                l += 1
        return ans