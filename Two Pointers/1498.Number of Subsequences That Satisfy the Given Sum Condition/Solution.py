class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        mod = int(1e9 + 7)
        n = len(nums)
        f = [0] * n
        f[0] = 1
        for i in range(n - 1):
            f[i + 1] = f[i] * 2 % mod
        nums.sort()
        ans, l, r = 0, 0, n - 1
        while l <= r:
            if nums[l] + nums[r] <= target:
                ans += f[r - l]
                l += 1
            else:
                r -= 1
        return ans % mod

