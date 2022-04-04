class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if matrix[mid][0] > target:
                right = mid - 1
            else:
                left = mid
        row = matrix[left]
        left, right = 0, n - 1
        while left < right:
            mid = (left + right) >> 1
            if row[mid] < target:
                left = mid + 1
            else:
                right = mid
        return row[left] == target