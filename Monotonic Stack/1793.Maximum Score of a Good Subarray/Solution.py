class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        n = len(nums)
        left = [-1] * n
        q = []
        for i, v in enumerate(nums):
            while q and nums[q[-1]] >= v:
                q.pop()
            if q:
                left[i] = q[-1]
            q.append(i)
        right = [n] * n
        q.clear()
        for i in range(n - 1, -1, -1):
            v = nums[i]
            while q and v <= nums[q[-1]]:
                q.pop()
            if q:
                right[i] = q[-1]
            q.append(i)
        ans = 0
        for h, l, r in zip(nums, left, right):
            if l < k < r:
                ans = max(ans, h * (r - l - 1))
        return ans