class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])

        def exist_num(target):
            for i in range(1, m):
                left, right = 0, n - 1
                while left < right:
                    mid = (left + right) >> 1
                    if mat[i][mid] < target:
                        left = mid + 1
                    else:
                        right = mid
                if mat[i][left] != target:
                    return False
            return True

        for v in mat[0]:
            if exist_num(v):
                return v
        return -1