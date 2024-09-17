class Solution:
    def occurrencesOfElement(self, nums: List[int], queries: List[int], x: int) -> List[int]:
        qs = [[v, i] for i, v in enumerate(queries)]
        qs.sort(key=lambda x : x[0])
        n = len(queries)
        ans = [-1] * n
        j = s = 0
        for i, v in enumerate(nums):
            if v == x:
                s += 1
            while j < n and s >= qs[j][0]:
                ans[qs[j][1]] = i
                j += 1
        return ans