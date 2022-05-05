class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        cur, left, ans = 1, 0, 0
        for i, v in enumerate(nums):
            cur *= v
            while left < i and cur >= k:
                cur //= nums[left]
                left += 1
            if cur < k:
                ans += i - left + 1
        return ans