class Solution:
    def maxPower(self, s: str) -> int:
        res, cur_count, cur = 1, 1, s[0]
        for i in range(1, len(s)):
            if cur == s[i]:
                cur_count += 1
            else:
                cur = s[i]
                cur_count = 1
            res = max(cur_count, res)
        return res