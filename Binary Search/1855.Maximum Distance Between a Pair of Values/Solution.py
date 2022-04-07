class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        n, m = len(nums1), len(nums2)
        ans = 0
        for i, v in enumerate(nums1):
            left, right = i, m - 1
            if right - left <= ans:
                break
            while left < right:
                mid = (left + right + 1) >> 1
                if v <= nums2[mid]:
                    left = mid
                else:
                    right = mid - 1
            if i <= left and v <= nums2[left]:
                ans = max(ans, left - i)
        return ans