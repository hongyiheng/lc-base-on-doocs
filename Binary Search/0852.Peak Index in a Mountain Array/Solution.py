class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        left, right = 1, len(arr) - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if arr[mid] >= arr[mid - 1]:
                left = mid
            else:
                right = mid - 1
        return left