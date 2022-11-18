class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        mod = int(1e9 + 7)
        n = len(nums)
        p = [1] * n
        for i in range(1, n):
            p[i] = p[i - 1] * 2 % mod
        nums.sort()
        ans = 0
        for i in range(n):
            ans += (p[i] - p[n - i - 1]) * nums[i]
            ans %= mod
        return ans
