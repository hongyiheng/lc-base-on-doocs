class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        max_len = 0
        for r in rectangles:
            max_len = max(max_len, min(r[0], r[1]))
        ans = 0
        for r in rectangles:
            if min(r[0], r[1]) == max_len:
                ans += 1
        return ans