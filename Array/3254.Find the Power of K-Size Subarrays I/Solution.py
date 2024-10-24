class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        ans, q = [], []
        for i, v in enumerate(nums):
            if not q or nums[q[-1]] + 1 != v:
                q.clear()
            q.append(i)
            if i >= k - 1:
                if len(q) == k:
                    ans.append(v)
                    q.pop(0)
                else:
                    ans.append(-1)
        return ans