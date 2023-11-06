class Solution:
    def minimumLines(self, stockPrices: List[List[int]]) -> int:
        if len(stockPrices) <= 1:
            return 0
        stockPrices.sort(key=lambda x: x[0])
        ans = 1
        for i in range(2, len(stockPrices)):
            x1, y1 = stockPrices[i - 2]
            x2, y2 = stockPrices[i - 1]
            x3, y3 = stockPrices[i]
            if (x2 - x1) * (y3 - y2) != (x3 - x2) * (y2 - y1):
                ans += 1
        return ans


