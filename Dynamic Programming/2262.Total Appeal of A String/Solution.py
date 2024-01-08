class Solution:
    def appealSum(self, s: str) -> int:
        ans = cnt = 0
        last = [-1] * 26
        for i, c in enumerate(s):
            cnt += i - last[ord(c) - ord('a')]
            ans += cnt
            last[ord(c) - ord('a')] = i
        return ans