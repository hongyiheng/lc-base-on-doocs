class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(n):
            if nums[i] >= k:
                return 1
            pre[i + 1] = pre[i] + nums[i]
        lefts = deque()
        ans = float("inf")
        for r in range(n + 1):
            while lefts and pre[r] <= pre[lefts[-1]]:
                lefts.pop()
            while lefts and pre[r] - pre[lefts[0]] >= k:
                ans = min(ans, r - lefts.popleft())
            lefts.append(r)
        return -1 if ans == float("inf") else ans