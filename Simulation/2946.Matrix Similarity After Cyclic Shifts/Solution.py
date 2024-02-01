class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        m, n = len(mat), len(mat[0])
        k %= n
        if not k:
            return True
        for i in range(m):
            for j in range(n):
                t = (j - k + n) % n if not i % 2 else (j + k) % n
                if mat[i][j] != mat[i][t]:
                    return False
        return True