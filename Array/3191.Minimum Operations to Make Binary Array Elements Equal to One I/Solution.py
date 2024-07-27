class Solution:
    def minOperations(self, nums: List[int]) -> int:
        ans = 0
        for i, v in enumerate(nums):
            if v == 1:
                continue
            if i + 2 >= len(nums):
                return -1
            for j in range(i + 1, i + 3):
                nums[j] ^= 1
            ans += 1
        return ans