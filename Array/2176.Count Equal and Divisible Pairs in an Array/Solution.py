class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        ans = 0
        for i, a in enumerate(nums):
            for j, b in enumerate(nums[i + 1:], i + 1):
                if a == b and i * j % k == 0:
                    ans += 1
        return ans

