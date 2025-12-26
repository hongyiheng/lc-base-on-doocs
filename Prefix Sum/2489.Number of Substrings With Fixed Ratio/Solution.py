class Solution:
    def bestClosingTime(self, customers: str) -> int:
        n = len(customers)
        totalY = sum(1 for c in customers if c == 'Y')
        mi = totalY
        ans = 0
        openY = 0
        for i in range(1, n + 1):
            if customers[i-1] == 'Y':
                openY += 1
            v = i - 2 * openY + totalY
            if v < mi:
                mi = v
                ans = i
        return ans