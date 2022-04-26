class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        n = len(arr)
        left_end, right_start = 0, n - 1
        while left_end < n - 1 and arr[left_end] <= arr[left_end + 1]:
            left_end += 1
        if left_end == n - 1:
            return 0
        while right_start > 1 and arr[right_start] >= arr[right_start - 1]:
            right_start -= 1
        if arr[right_start] >= arr[left_end]:
            return right_start - left_end - 1
        ans = min(right_start, n - left_end - 1)
        for i in range(left_end + 1):
            left, right = right_start, n - 1
            while left < right:
                mid = (left + right) >> 1
                if arr[mid] >= arr[i]:
                    right = mid
                else:
                    left = mid + 1
            if arr[left] < arr[i]:
                break
            ans = min(ans, left - i - 1)
        return ans