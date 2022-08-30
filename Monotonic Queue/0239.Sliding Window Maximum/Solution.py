class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = deque()
        n = len(nums)
        ans = [0] * (n - k + 1)
        for i in range(n):
            while q and nums[q[-1]] <= nums[i]:
                q.pop()
            q.append(i)
            if i >= k - 1:
                while q and q[0] <= i - k:
                    q.popleft()
                ans[i - k + 1] = nums[q[0]]
        return ans