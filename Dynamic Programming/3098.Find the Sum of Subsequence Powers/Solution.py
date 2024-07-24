class Solution:
    def sumOfPowers(self, nums: List[int], k: int) -> int:
        @cache
        def dfs(i, j, k, mi) -> int:
            if i >= n:
                return mi if k == 0 else 0
            if n - i < k:
                return 0
            ans = dfs(i + 1, j, k, mi)
            if j == n:
                ans += dfs(i + 1, i, k - 1, mi)
            else:
                ans += dfs(i + 1, i, k - 1, min(mi, nums[i] - nums[j]))
            return ans % mod

        mod = int(1e9 + 7)
        n = len(nums)
        nums.sort()
        return dfs(0, n, k, inf)