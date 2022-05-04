# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left, right = 0, 10000
        while left < right:
            mid = (left + right + 1) >> 1
            if reader.get(mid) <= target:
                left = mid
            else:
                right = mid - 1
        return left if reader.get(left) == target else -1