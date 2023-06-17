class Solution:
    def matrixSumQueries(self, n: int, queries: List[List[int]]) -> int:
        row, col = set(), set()
        ans = 0
        for i in range(len(queries) - 1, -1, -1):
            t, idx, val = queries[i]
            if t == 0:
                if idx not in row:
                    row.add(idx)
                    ans += val * (n - len(col))
            else:
                if idx not in col:
                    col.add(idx)
                    ans += val * (n - len(row))
        return ans
