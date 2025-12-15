class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        ans = s = 1
        for i in range(1, len(prices)):
            if prices[i - 1] - prices[i] == 1:
                s += 1
            else:
                s = 1
            ans += s
        return ans
