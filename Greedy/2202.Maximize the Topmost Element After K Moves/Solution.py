class Solution:
    def maximumTop(self, nums: List[int], k: int) -> int:
        n = len(nums)
        if n == 1 and k % 2 != 0:
            return -1
        ans = -1
        if n >= k:
            for i in range(k - 1):
                ans = max(ans, nums[i])
            if n > k:
                ans = max(ans, nums[k])
        if n < k:
            ans = max(nums)
        return ans