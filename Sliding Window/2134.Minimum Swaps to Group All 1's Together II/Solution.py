class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        win, n = nums.count(1), len(nums)
        if win == 0 or win == n:
            return 0
        s = [0] * (n + win)
        for i in range(win):
            s[0] += nums[i]
        for i in range(1, n):
            right = (i + win - 1) % n
            s[i] = s[i - 1] + nums[right] - nums[i - 1]
        ans = n
        for v in s:
            ans = min(ans, win - v)
        return ans