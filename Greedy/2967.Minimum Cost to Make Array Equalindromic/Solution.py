class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        def f(x):
            v, t = x, 0
            while v:
                t = t * 10 + v % 10
                v //= 10
            if t != x:
                return -1
            ans = 0
            for v in nums:
                ans += abs(v - x)
            return ans

        nums.sort()
        n = len(nums)
        mid = nums[n // 2] if n % 2 else (nums[n // 2] + nums[n // 2 - 1]) // 2
        ans = inf
        for v in range(mid, -1, -1):
            if f(v) != -1:
                ans = f(v)
                break
        while True:
            if f(mid) != -1:
                return min(ans, f(mid))
            mid += 1
