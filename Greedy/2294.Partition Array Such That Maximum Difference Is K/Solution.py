class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        nums.sort()
        mi = nums[0]
        ans = 1
        for v in nums:
            if v - mi > k:
                mi = v
                ans += 1
        return ans