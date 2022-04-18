class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        mod = 1e9 + 7
        nums = nums1[:]
        nums.sort()
        s, max_diff, n = 0, 0, len(nums1)
        for i in range(n):
            cur = abs(nums1[i] - nums2[i])
            s += cur
            if cur > max_diff:
                left, right = 0, n - 1
                while left < right:
                    mid = (left + right) >> 1
                    if nums[mid] < nums2[i]:
                        left = mid + 1
                    else:
                        right = mid
                diff = abs(nums[left] - nums2[i])
                if left > 0:
                    diff = min(diff, abs(nums[left - 1] - nums2[i]))
                max_diff = max(max_diff, cur - diff)
        return int((s - max_diff) % mod)