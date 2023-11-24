class Solution:
    def countPairs(self, nums: List[int], target: int) -> int:
        n, ans = len(nums), 0
        nums.sort()
        for i in range(n):
            l, r = i + 1, n - 1
            while l < r:
                mid = (l + r + 1) >> 1
                if nums[i] + nums[mid] < target:
                    l = mid
                else:
                    r = mid - 1
            if nums[i] + nums[r] < target:
                ans += r - i
        return ans