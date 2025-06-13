class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        def check(x):
            cnt = i = 0
            while i < len(nums) - 1:
                if nums[i + 1] - nums[i] <= x:
                    cnt += 1
                    i += 2
                else:
                    i += 1
            return cnt >= p

        nums.sort()
        l, r = 0, nums[-1] - nums[0]
        while l < r:
            mid = (l + r) >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return r