class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        arr2.sort()
        ans = 0
        for num in arr1:
            left, right = 0, len(arr2) - 1
            while left < right:
                mid = (left + right) >> 1
                if arr2[mid] < num:
                    left = mid + 1
                else:
                    right = mid
            if abs(num - arr2[left]) <= d:
                continue
            left, right = 0, len(arr2) - 1
            while left < right:
                mid = (left + right + 1) >> 1
                if arr2[mid] > num:
                    right = mid - 1
                else:
                    left = mid
            if abs(num - arr2[left]) <= d:
                continue
            ans += 1
        return ans