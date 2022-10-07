class Solution:
    def longestPalindrome(self, s: str) -> int:
        n = ord('z') - ord('A') + 1
        cnt = [0] * n
        for c in s:
            cnt[ord(c) - ord('A')] += 1
        ans = 0
        extra = False
        for v in cnt:
            ans += v // 2 * 2
            if v % 2 != 0:
                extra = True
        return ans + 1 if extra else ans
