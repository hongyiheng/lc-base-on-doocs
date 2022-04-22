class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        n = len(nums)
        s, cur = 0, 0
        for i, v in enumerate(nums):
            s += v
            cur += i * v
        ans = cur
        last = n - 1
        for _ in range(n):
            cur = cur - n * nums[last] + s
            ans = max(ans, cur)
            last = (last - 1 + n) % n
        return ans