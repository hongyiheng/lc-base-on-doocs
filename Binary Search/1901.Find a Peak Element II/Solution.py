class Solution:
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        m, n = len(mat), len(mat[0])
        l, r = 0, m - 1
        while l < r:
            mid = (l + r) >> 1
            mx = max(mat[mid])
            j = mat[mid].index(mx)
            if mid < m - 1 and mat[mid][j] <= mat[mid + 1][j]:
                l = mid + 1
            else:
                r = mid
        return [l, mat[l].index(max(mat[l]))]