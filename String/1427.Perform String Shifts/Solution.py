class Solution:
    def stringShift(self, s: str, shift: List[List[int]]) -> str:
        cnt = 0
        for a, b in shift:
            if a == 0:
                cnt += b
            else:
                cnt -= b
        cnt = cnt % len(s)
        return s[cnt:] + s[:cnt]