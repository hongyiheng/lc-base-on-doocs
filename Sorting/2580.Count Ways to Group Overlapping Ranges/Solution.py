class Solution:
    def countWays(self, ranges: List[List[int]]) -> int:
        ranges.sort(key=lambda x:x[0])
        x, max_r = 0, -1
        for l, r in ranges:
            if l > max_r:
                x += 1
            max_r = max(max_r, r)
        return pow(2, x, int(1e9 + 7))