class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        t = nums[0] + nums[1]
        ans = 0
        for i in range(1, len(nums), 2):
            if nums[i - 1] + nums[i] != t:
                break
            ans += 1
        return ans