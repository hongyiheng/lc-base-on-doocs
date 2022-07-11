class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m, n = len(nums1), len(nums2)
        nums = [0] * (m + n)
        l = r = 0
        while l < m or r < n:
            if l < m and r < n:
                if nums1[l] <= nums2[r]:
                    nums[l + r] = nums1[l]
                    l += 1
                else:
                    nums[l + r] = nums2[r]
                    r += 1
            elif l < m:
                nums[l + r] = nums1[l]
                l += 1
            else:
                nums[l + r] = nums2[r]
                r += 1
        if (m + n) % 2 == 0:
            ans = (nums[(m + n) // 2] + nums[(m + n) // 2 - 1]) / 2
        else:
            ans = nums[(m + n) // 2]
        return ans