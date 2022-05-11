class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cnt = dict()
        left, n, ans = 0, len(s), 0
        for right in range(n):
            while cnt.get(s[right], 0) == 1:
                cnt[s[left]] = 0
                left += 1
            cnt[s[right]] = 1
            ans = max(ans, right - left + 1)
        return ans