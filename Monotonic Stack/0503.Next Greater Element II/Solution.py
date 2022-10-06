class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        q = deque()
        for i, v in enumerate(nums):
            while q and q[-1][1] < v:
                ans[q.pop()[0]] = v
            q.append([i, v])
        for i, v in enumerate(nums):
            while q and q[-1][1] < v:
                ans[q.pop()[0]] = v
        return ans
