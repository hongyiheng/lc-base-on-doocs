class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        m, n = len(strs), len(strs[0])
        ans = 0
        for j in range(n):
            last = strs[0][j]
            for i in range(1, m):
                if strs[i][j] < last:
                    ans += 1
                    break
                last = strs[i][j]
        return ans