class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        ans, cnt = 0, 0
        for c in s:
            if c == '1':
                cnt += 1
            else:
                ans = min(ans + 1, cnt)
        return ans