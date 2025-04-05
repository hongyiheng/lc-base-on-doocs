class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        def dfs(i, v):
            nonlocal n
            if i == n:
                return v
            ans = dfs(i + 1, v ^ nums[i])
            ans += dfs(i + 1, v)
            return ans

        n = len(nums)
        return dfs(0, 0)