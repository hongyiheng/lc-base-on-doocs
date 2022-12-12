class Solution:
    def beautySum(self, s: str) -> int:
        ans = 0
        for i in range(len(s)):
            cnt = dict()
            for j in range(i, len(s)):
                idx = ord(s[j]) - ord('a')
                cnt[idx] = cnt.get(idx, 0) + 1
                ans += max(cnt.values()) - min(cnt.values())
        return ans
