class Solution:
    def numberOfSubstrings(self, s: str, k: int) -> int:
        cnt = [0] * 26
        n = len(s)
        ans = l = 0
        for r in range(n):
            cnt[ord(s[r]) - ord('a')] += 1
            while max(cnt) >= k:
                ans += n - r
                cnt[ord(s[l]) - ord('a')] -= 1
                l += 1
        return ans