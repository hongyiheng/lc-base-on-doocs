class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        mp = defaultdict(int)
        for i in range(m):
            q1, q2 = [], []
            for j in range(n):
                q1.append(str(matrix[i][j]))
                q2.append(str(matrix[i][j] ^ 1))
            mp["".join(q1)] += 1
            mp["".join(q2)] += 1
        return max(mp.values())
