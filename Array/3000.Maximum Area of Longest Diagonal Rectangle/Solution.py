class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        mx = ans = 0
        for h, w in dimensions:
            v, s = h * h + w * w, h * w
            if v > mx or (v == mx and s > ans):
                mx = v
                ans = s
        return ans