class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        q = []
        for i, v in enumerate(nums):
            while q and q[-1] > v and n - i > k - len(q):
                q.pop()
            if len(q) < k:
                q.append(v)
        return q