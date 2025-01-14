class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        ans = 0
        for v in nums:
            if v < k:
                ans += 1
        return ans
