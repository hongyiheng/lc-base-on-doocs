class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:
        def dfs(i, msk):
            if i >= len(nums):
                return 1 if msk else 0
            ans = dfs(i + 1, msk)
            for j in range(len(nums)):
                if msk >> j & 1 and abs(nums[j] - nums[i]) == k:
                    return ans
            ans += dfs(i + 1, msk | 1 << i)
            return ans

        return dfs(0, 0)

