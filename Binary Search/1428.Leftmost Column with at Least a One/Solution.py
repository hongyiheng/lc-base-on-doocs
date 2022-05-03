# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
#class BinaryMatrix(object):
#    def get(self, row: int, col: int) -> int:
#    def dimensions(self) -> list[]:

class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        m, n = binaryMatrix.dimensions()
        ans = -1
        for i in range(m):
            left, right = 0, n - 1
            while left < right:
                mid = (left + right) >> 1
                if binaryMatrix.get(i, mid) == 0:
                    left = mid + 1
                else:
                    right = mid
            if binaryMatrix.get(i, left) == 1:
                ans = left if ans == -1 else min(ans, left);
        return ans