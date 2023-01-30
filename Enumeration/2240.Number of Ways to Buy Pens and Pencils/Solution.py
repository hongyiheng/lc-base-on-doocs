class Solution:
    def waysToBuyPensPencils(self, total: int, cost1: int, cost2: int) -> int:
        ans = i = 0
        while i * cost1 <= total:
            ans += (total - i * cost1) // cost2 + 1
            i += 1
        return ans
