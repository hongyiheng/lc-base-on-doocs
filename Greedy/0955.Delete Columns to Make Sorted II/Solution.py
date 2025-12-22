class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        m, n = len(strs), len(strs[0])
        if m == 1:
            return 0
        ans = 0
        row = set()
        for j in range(n):
            tmp_row = set()
            for i in range(1, m):
                if (i - 1, i) in row:
                    continue
                a, b = strs[i - 1][j], strs[i][j]
                if a > b:
                    ans += 1
                    tmp_row.clear()
                    break
                elif a < b:
                    tmp_row.add((i - 1, i))
            row |= tmp_row
        return ans
