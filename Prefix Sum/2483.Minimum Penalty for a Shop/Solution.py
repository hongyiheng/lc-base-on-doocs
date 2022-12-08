class Solution:
    def bestClosingTime(self, customers: str) -> int:
        n = y = 0
        customers = customers + "N"
        for c in customers:
            if c == 'Y':
                y += 1
        ans, cur = 0, float('inf')
        for i, c in enumerate(customers):
            if cur > n + y:
                cur = n + y
                ans = i
            if c == 'Y':
                y -= 1
            else:
                n += 1
        return ans
