class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        m = len(matrix)
        n = len(matrix[0])
        left, right = matrix[0][0], matrix[m - 1][n - 1]

        def getLessNumCount(mid):
            row, col = m - 1, 0
            res = 0
            while row >= 0 and col < n:
                if matrix[row][col] <= mid:
                    res += row + 1
                    col += 1
                else:
                    row -= 1
            return res

        while left < right:
            mid = (left + right) >> 1
            if getLessNumCount(mid) < k:
                left = mid + 1
            else:
                right = mid
        return left