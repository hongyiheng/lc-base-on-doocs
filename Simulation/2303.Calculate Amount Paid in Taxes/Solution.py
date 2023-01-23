class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        last = ans = 0
        for u, p in brackets:
            if income <= last:
                break
            ans += (min(income, u) - last) * p / 100
            last = u
        return ans