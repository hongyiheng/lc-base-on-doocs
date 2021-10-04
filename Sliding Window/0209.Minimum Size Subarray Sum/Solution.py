class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left, right, count, ans = 0, 0, 0, sys.maxsize
        n = len(nums)
        while right < n:
            count += nums[right]
            right += 1
            while count >= target:
                ans = min(ans, right - left)
                count -= nums[left]
                left += 1
        return 0 if ans == sys.maxsize else ans