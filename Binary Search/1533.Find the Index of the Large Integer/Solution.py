# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#	 # Compares the sum of arr[l..r] with the sum of arr[x..y]
#	 # return 1 if sum(arr[l..r]) > sum(arr[x..y])
#	 # return 0 if sum(arr[l..r]) == sum(arr[x..y])
#	 # return -1 if sum(arr[l..r]) < sum(arr[x..y])
#    def compareSub(self, l: int, r: int, x: int, y: int) -> int:
#
#	 # Returns the length of the array
#    def length(self) -> int:
#


class Solution:
    def getIndex(self, reader: 'ArrayReader') -> int:
        left, right = 0, reader.length() - 1
        while left < right:
            mid = (left + right) >> 1
            if (right - left + 1) % 2 == 0:
                compare = reader.compareSub(left, mid, mid + 1, right)
                if compare == 1:
                    right = mid
                else:
                    left = mid + 1
            else:
                compare = reader.compareSub(left, mid - 1, mid + 1, right)
                if compare == 0:
                    return mid
                elif compare == 1:
                    right = mid - 1
                else:
                    left = mid + 1
        return left