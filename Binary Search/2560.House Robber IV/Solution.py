class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        def check(x):
            f0, f1 = 0, 1 if nums[0] <= x else 0
            for i in range(2, len(nums) + 1):
                cur = f1
                if nums[i - 1] <= x:
                    cur = max(cur, f0 + 1)
                f0, f1 = f1, cur
            return max(f0, f1) >= k

        l, r = 0, int(1e9)
        while l < r:
            mid = (l + r) >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return r