class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        def search_left(x, l):
            r = len(nums)
            while l < r:
                mid = (l + r) >> 1
                if nums[mid] < x:
                    l = mid + 1
                else:
                    r = mid
            return r

        nums.sort()
        ans = 0
        for i, v in enumerate(nums):
            l = search_left(lower - v, i + 1)
            r = search_left(upper - v + 1, i + 1) - 1
            if r >= l:
                ans += r - l + 1
        return ans

