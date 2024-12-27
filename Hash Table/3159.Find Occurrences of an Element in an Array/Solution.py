class Solution:
    def occurrencesOfElement(self, nums: List[int], queries: List[int], x: int) -> List[int]:
        q = []
        for i, v in enumerate(nums):
            if v == x:
                q.append(i)
        return [-1 if v > len(q) else q[v - 1] for v in queries]
