class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        cnt = [0] * 3
        n = len(s)
        ans = l = r = 0
        while r < n:
            cnt[ord(s[r]) - ord('a')] += 1
            while cnt[0] and cnt[1] and cnt[2]:
                ans += n - r
                cnt[ord(s[l]) - ord('a')] -= 1
                l += 1
            r += 1
        return ans