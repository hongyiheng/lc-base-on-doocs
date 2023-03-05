class Solution:
    def minOperationsMaxProfit(self, customers: List[int], boardingCost: int, runningCost: int) -> int:
        i, n = 0, len(customers)
        up, w, mx, ans = 0, 0, 0, -1
        while i < n or w:
            if i < n:
                w += customers[i]
            i += 1
            up += min(4, w)
            w -= min(4, w)
            cur = up * boardingCost - i * runningCost
            if cur > mx:
                mx = cur
                ans = i
        return ans