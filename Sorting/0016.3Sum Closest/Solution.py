class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n, ans = len(nums), float('inf')
        for i in range(n):
            left, right = i + 1, n - 1
            while left < right:
                cur = nums[i] + nums[left] + nums[right]
                if abs(cur - target) <= abs(ans - target):
                    ans = cur
                if cur < target:
                    left += 1
                else:
                    right -= 1
        return ans
