class Solution:
    def coloredCells(self, n: int) -> int:
        ans = 2 * n - 1
        cur = 1
        for i in range(n - 1):
            ans += cur * 2
            cur += 2
        return ans



