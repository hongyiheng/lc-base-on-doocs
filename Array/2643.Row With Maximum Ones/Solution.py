class Solution:
    def rowAndMaximumOnes(self, mat: List[List[int]]) -> List[int]:
        ans = [0, 0]
        for i, row in enumerate(mat):
            v = sum(row)
            if v > ans[1]:
                ans = [i, v]
        return ans