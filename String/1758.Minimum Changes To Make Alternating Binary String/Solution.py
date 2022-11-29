class Solution:
    def minOperations(self, s: str) -> int:
        ans1 = ans2 = 0
        cur = '0'
        for c in s:
            if c == cur:
                ans1 += 1
            else:
                ans2 += 1
            cur = '1' if cur == '0' else '0'
        return min(ans1, ans2)
