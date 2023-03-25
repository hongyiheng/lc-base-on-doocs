class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        n, right = len(arr), len(arr) - 1
        while right > 0 and arr[right - 1] <= arr[right]:
            right -= 1
        if right == 0:
            return 0
        ans = right
        for left in range(n):
            if left > 0 and arr[left] < arr[left - 1]:
                break
            while right < n and arr[right] < arr[left]:
                right += 1
            ans = min(ans, right - left - 1)
        return ans