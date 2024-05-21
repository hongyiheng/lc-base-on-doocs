class Solution:
    def rowAndMaximumOnes(self, mat: List[List[int]]) -> List[int]:
        ans = mx = 0
        for i, row in enumerate(mat):
            cnt = sum(row)
            if cnt > mx:
                mx = cnt
                ans = i
        return [ans, mx]