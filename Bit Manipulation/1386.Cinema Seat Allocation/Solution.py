class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        M = (1 << 11) - 1
        L = MID = R = 0
        for i in range(2, 6):
            L |= 1 << i
            MID |= 1 << (i + 2)
            R |= 1 << (i + 4)

        g = dict()
        for i, j in reservedSeats:
            g[i] = g.get(i, M) ^ (1 << j)
        ans = 2 * n
        for v in g.values():
            l = v & L == L
            r = v & R == R
            mid = v & MID == MID
            if l and r:
                continue
            if l or r or mid:
                ans -= 1
            else:
                ans -= 2
        return ans

