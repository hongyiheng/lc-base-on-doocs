class Solution:
    def stoneGameIX(self, stones: List[int]) -> bool:
        m = [0, 0, 0]
        for stone in stones:
            m[stone % 3] += 1
        if m[0] % 2 == 0:
            return m[1] > 0 and m[2] > 0
        return abs(m[1] - m[2]) > 2