class Solution:
    def countKDifference(self, nums: List[int], k: int) -> int:
        n, ans = len(nums), 0
        for i in range(n - 1, -1, -1):
            for j in range(i - 1, -1, -1):
                if abs(nums[i] - nums[j]) == k:
                    ans += 1
        return ans