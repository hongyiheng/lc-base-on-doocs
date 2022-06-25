class Solution:
    def minDeletion(self, nums: List[int]) -> int:
        n, ans = len(nums), 0
        for i in range(n - 1):
            if (i - ans) % 2 == 0 and nums[i] == nums[i + 1]:
                ans += 1
        return ans if (n - ans) % 2 == 0 else ans + 1