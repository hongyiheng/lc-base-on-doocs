class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        cnt = Counter(s)
        for c in cnt.keys():
            if cnt[c] < k:
                ans = 0
                for ss in s.split(c):
                    ans = max(ans, self.longestSubstring(ss, k))
                return ans
        return len(s)