class Solution:
    def specialPerm(self, nums: List[int]) -> int:
        @cache
        def dfs(use, pre):
            nonlocal n, mod
            if use == (1 << n) - 1:
                return 1
            ans = 0
            for i, v in enumerate(nums):
                if use >> i & 1 == 0 and (pre % v == 0 or v % pre == 0):
                    ans += dfs(use | 1 << i, v)
            return ans % mod

        n = len(nums)
        mod = int(1e9 + 7)
        return sum(dfs(1 << i, v) for i, v in enumerate(nums)) % mod