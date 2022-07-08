class Solution:
    def minCostToMoveChips(self, position: List[int]) -> int:
        a = b = 0
        for p in position:
            if p % 2:
                a += 1
            else:
                b += 1
        return min(a, b)