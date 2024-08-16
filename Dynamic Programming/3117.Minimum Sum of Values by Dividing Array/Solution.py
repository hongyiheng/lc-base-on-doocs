class Solution:
    def minimumValueSum(self, nums: List[int], andValues: List[int]) -> int:
        @cache
        def dfs(i, j, msk):
            nonlocal n, m
            if n - i < m - j:
                return inf
            if j == m:
                return 0 if i == n else inf
            msk &= nums[i]
            if msk < andValues[j]:
                return inf
            ans = dfs(i + 1, j, msk)
            if msk == andValues[j]:
                ans = min(ans, dfs(i + 1, j + 1, -1) + nums[i])
            return ans

        n, m = len(nums), len(andValues)
        ans = dfs(0, 0, -1)
        return -1 if ans >= inf else ans
