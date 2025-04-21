class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        last = mi = mx = lower
        for v in differences:
            cur = last + v
            mx = max(mx, cur)
            mi = min(mi, cur)
            last = cur
        return max(0, upper - mx + 1 - max(0, lower - mi))
        