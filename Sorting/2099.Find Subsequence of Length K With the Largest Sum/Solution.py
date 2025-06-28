class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        q = [(i, v) for i, v in enumerate(nums)]
        q.sort(key=lambda x:-x[1])
        q = q[:k]
        q.sort(key=lambda x:x[0])
        return [v for _, v in q]