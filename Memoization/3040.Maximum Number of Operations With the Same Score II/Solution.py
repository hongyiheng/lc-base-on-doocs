class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        @cache
        def f(l, r, t):
            if r - l + 1 < 2:
                return 0
            ans = 0
            if nums[l] + nums[l + 1] == t:
                ans = max(f(l + 2, r, t) + 1, ans)

            if nums[l] + nums[r] == t:
                ans = max(f(l + 1, r - 1, t) + 1, ans)
            if nums[r] + nums[r - 1] == t:
                ans = max(f(l, r - 2, t) + 1, ans)
            return ans

        n = len(nums)
        return max(f(0, n - 1, nums[0] + nums[1]), f(0, n - 1, nums[0] + nums[-1]), f(0, n - 1, nums[-1] + nums[-2]))