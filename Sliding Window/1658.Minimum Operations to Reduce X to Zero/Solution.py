class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        n = len(nums)
        t = sum(nums) - x
        if t < 0:
            return -1
        if t == 0:
            return n
        left = right = ans = cur = 0
        while right < n:
            cur += nums[right]
            while cur > t:
                cur -= nums[left]
                left += 1
            if cur == t:
                ans = max(ans, right - left + 1)
            right += 1
        return -1 if ans == 0 else n - ans